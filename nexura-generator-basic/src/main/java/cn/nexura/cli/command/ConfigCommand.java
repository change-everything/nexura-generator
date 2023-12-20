package cn.nexura.cli.command;

import cn.hutool.core.util.ReflectUtil;
import cn.nexura.model.MainTemplateConfig;
import picocli.CommandLine.*;

import java.lang.reflect.Field;

/**
 * @author PeiYP
 * @since 2023年12月20日 17:55
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("查看参数信息");

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        for (Field field : fields) {
            System.out.println("field.getName() = " + field.getName());
            System.out.println("field.getName() = " + field.getType());

            System.out.println("---");
        }
    }
}
