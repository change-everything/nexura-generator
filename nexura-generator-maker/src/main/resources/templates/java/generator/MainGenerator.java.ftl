package ${basePackage}.generator.file;

import ${basePackage}.model.DataModel;

import ${basePackage}.generator.file.DynamicGenerator;
import ${basePackage}.generator.file.StaticGenerator;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author ${author}
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, TemplateException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

        <#list fileConfig.files as file>
        inputPath = new File(inputRootPath, "${file.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${file.outputPath}").getAbsolutePath();
        <#if file.generateType == "static">
        StaticGenerator.copyFiles(inputPath, outputPath);
        <#else>
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
        </#if>
        </#list>
    }

}