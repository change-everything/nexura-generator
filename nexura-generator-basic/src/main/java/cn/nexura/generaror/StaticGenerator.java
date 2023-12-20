package cn.nexura.generaror;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

/**
 * @author PeiYP
 * @since 2023年12月20日 15:04
 */
public class StaticGenerator {


    /**
     * 使用工具类
     */
    public static void copyFiles(String inputPath, String outPutPath) {
        FileUtil.copy(inputPath, outPutPath, false);
    }

    /**
     * 递归拷贝文件
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            copyFilesByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    private static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是不是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下所有文件夹和文件
            File[] files = inputFile.listFiles();
            // 无子文件直接退出
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                copyFilesByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制到目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }


}
