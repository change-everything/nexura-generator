package cn.nexura.maker.template;

import cn.hutool.core.util.StrUtil;
import cn.nexura.maker.meta.Meta;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 模板制作工具类
 * @author PeiYP
 * @since 2023年12月26日 16:27
 */
public class TemplateMakerUtils {

    /**
     * 从未分组的文件中移除已分组中重复的文件
     */
    public static List<Meta.FileConfig.FileInfo> removeGroupFilesFromRoot(List<Meta.FileConfig.FileInfo> fileInfoList) {


        // 先获取到所有分组
        List<Meta.FileConfig.FileInfo> groupFileInfoList = fileInfoList.stream()
                .filter(fileInfo -> StrUtil.isNotBlank(fileInfo.getGroupKey()))
                .collect(Collectors.toList());

        // 获取分组下所有文件列表
        List<Meta.FileConfig.FileInfo> groupInnerFileInfoList = groupFileInfoList.stream()
                .flatMap(fileInfo -> fileInfo.getFiles().stream())
                .collect(Collectors.toList());

        // 获取所有子分组内文件的输入路径集合
        List<String> fileInputPathSet = groupInnerFileInfoList.stream()
                .map(Meta.FileConfig.FileInfo::getInputPath)
                .collect(Collectors.toList());

        // 移除所有在集合内的的重复文件
        return fileInfoList.stream()
                .filter(fileInfo -> !fileInputPathSet.contains(fileInfo.getInputPath()))
                .collect(Collectors.toList());

    }

}
