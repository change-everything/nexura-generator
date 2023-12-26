package cn.nexura.maker.template.model;

import lombok.Data;

/**
 * @author PeiYP
 * @since 2023年12月26日 16:22
 */
@Data
public class TemplateMakerOutputConfig {

    // 从未分组的文件中移除已分组中重复的文件
    private boolean removeGroupFilesFromRoot = true;

}
