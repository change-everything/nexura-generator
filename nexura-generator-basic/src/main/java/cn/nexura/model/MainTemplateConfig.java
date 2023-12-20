package cn.nexura.model;

import lombok.Data;

/**
 * @author PeiYP
 * @since 2023年12月20日 16:40
 */
@Data
public class MainTemplateConfig {
    private boolean loop;
    private String author = "peiYP";
    private String outputText = "sum = ";
}
