package ${basePackage}.generator.file;

import cn.hutool.core.io.FileUtil;


/**
 * @author PeiYP
 */
public class StaticGenerator {


    /**
     * 使用工具类
     */
    public static void copyFiles(String inputPath, String outPutPath) {
        FileUtil.copy(inputPath, outPutPath, false);
    }

}
