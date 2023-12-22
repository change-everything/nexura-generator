package cn.nexura.maker.generaror.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import cn.nexura.maker.generaror.JarGenerator;
import cn.nexura.maker.generaror.ScriptGenerator;
import cn.nexura.maker.generaror.file.DynamicFileGenerator;
import cn.nexura.maker.meta.Meta;
import cn.nexura.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author PeiYP
 * @since 2023年12月21日 18:10
 */
public class MainGenerator extends GenerateTemplate{

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦！");
    }

}
