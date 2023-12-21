package cn.nexura.maker.generaror.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author PeiYP
 * @since 2023年12月20日 15:04
 */
public class StaticFileGenerator {


    /**
     * 使用工具类
     */
    public static void copyFiles(String inputPath, String outPutPath) {
        FileUtil.copy(inputPath, outPutPath, false);
    }

}
