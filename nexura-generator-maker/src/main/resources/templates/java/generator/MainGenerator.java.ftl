package ${basePackage}.generator.file;

import ${basePackage}.model.DataModel;

import ${basePackage}.generator.file.DynamicGenerator;
import ${basePackage}.generator.file.StaticGenerator;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

<#macro generateFile indent fileInfo>
${indent}inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
${indent}outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
<#if fileInfo.generateType == "static">
${indent}StaticGenerator.copyFiles(inputPath, outputPath);
<#else>
${indent}DynamicGenerator.doGenerate(inputPath, outputPath, model);
</#if>
</#macro>


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
    public static void doGenerate(DataModel model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

        <#list modelConfig.models as modelInfo>
        <#if modelInfo.groupKey??>
        <#list modelInfo.models as subModelInfo>
        ${subModelInfo.type} ${subModelInfo.fieldName} = model.${modelInfo.groupKey}.${subModelInfo.fieldName};
        </#list>
        <#else>
        ${modelInfo.type} ${modelInfo.fieldName} = model.${modelInfo.fieldName};
        </#if>
        </#list>

        <#list fileConfig.files as fileInfo>
        <#if fileInfo.groupKey??>
        // groupKey = ${fileInfo.groupKey}
        <#if fileInfo.condition??>
        if(${fileInfo.condition}) {
        <#list fileInfo.files as fileInfo>
            <@generateFile fileInfo=fileInfo indent="           " />
        </#list>
        }
        <#else>
        <#list fileInfo.files as fileInfo>
            <@generateFile fileInfo=fileInfo indent="       " />
        </#list>
        </#if>
        <#else>
        <#if fileInfo.condition??>
        if(${fileInfo.condition}) {
            <@generateFile fileInfo=fileInfo indent="           " />
        }
        <#else>
            <@generateFile fileInfo=fileInfo indent="       " />
        </#if>
        </#if>
        </#list>
    }

}