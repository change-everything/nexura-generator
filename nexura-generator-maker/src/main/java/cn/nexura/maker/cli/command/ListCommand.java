package cn.nexura.maker.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.*;

import java.io.File;
import java.util.List;

/**
 * @author PeiYP
 * @since 2023年12月20日 17:56
 */
@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");

        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(parentFile, "nexura-generator-demo-project/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
