package cn.nexura.maker.template;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.nexura.maker.template.enums.FileFilterRangeEnum;
import cn.nexura.maker.template.enums.FileFilterRuleEnum;
import cn.nexura.maker.template.model.FileFilterConfig;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PeiYP
 * @since 2023年12月25日 17:54
 */
public class FileFilter {

    /**
     * 对某个文件或者目录进行过滤，返回文件列表
     */
    public static List<File> doFilter(String filePath, List<FileFilterConfig> filterConfigList) {
        // 根据路径获取所有文件
        List<File> fileList = FileUtil.loopFiles(filePath);
        return fileList.stream()
                .filter(file -> doSingleFileFilter(filterConfigList, file))
                .collect(Collectors.toList());
    }

    /**
     * 单个文件过滤
     */
    public static boolean doSingleFileFilter(List<FileFilterConfig> filterConfigList, File file) {
        String fileName = file.getName();
        String fileContent = FileUtil.readUtf8String(file);

        boolean result = true;

        if (CollUtil.isEmpty(filterConfigList)) {
            return true;
        }

        for (FileFilterConfig fileFilterConfig : filterConfigList) {
            String range = fileFilterConfig.getRange();
            String rule = fileFilterConfig.getRule();
            String value = fileFilterConfig.getValue();


            FileFilterRangeEnum fileFilterRangeEnum = FileFilterRangeEnum.getEnumByValue(range);
            if (null == fileFilterRangeEnum) {
                continue;
            }

            // 要过滤的原内容
            String content = fileName;
            switch (fileFilterRangeEnum) {

                case FILE_NAME:
                    content = fileName;
                    break;
                case FILE_CONTENT:
                    content = fileContent;
                    break;
                default:
                    break;
            }


            FileFilterRuleEnum fileFilterRuleEnum = FileFilterRuleEnum.getEnumByValue(rule);
            if (null == fileFilterRuleEnum) {
                continue;
            }

            switch (fileFilterRuleEnum) {

                case CONTAINS:
                    result = content.contains(value);
                    break;
                case STARTS_WITH:
                    result = content.startsWith(value);
                    break;
                case ENDS_WITH:
                    result = content.endsWith(value);
                    break;
                case REGEX:
                    result = content.matches(value);
                    break;
                case EQUALS:
                    result = content.equals(value);
                    break;
                default:
                    break;
            }


            if (!result) {
                return false;
            }

        }
        return true;
    }

}
