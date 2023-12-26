package cn.nexura.maker;

import cn.nexura.maker.generaror.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author peiYP
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }

}