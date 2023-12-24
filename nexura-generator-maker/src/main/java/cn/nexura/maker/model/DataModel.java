package cn.nexura.maker.model;

import lombok.Data;

/**
 * @author PeiYP
 * @since 2023年12月20日 16:40
 */
@Data
public class DataModel {
    private boolean needGit;
    private boolean loop;

    /**
     * 核心模板
     */
    public MainTemplate mainTemplate = new MainTemplate();

    /**
     * 用于生成核心模板文件
     */
    @Data
    public static class MainTemplate {
        /**
         * 作者注释
         */
        public String author = "yupi";

        /**
         * 输出信息
         */
        public String outputText = "sum = ";
    }

}
