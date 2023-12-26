package cn.nexura.maker.template.model;

import cn.nexura.maker.meta.Meta;
import lombok.Data;

/**
 * 模板制作配置
 * @author PeiYP
 * @since 2023年12月26日 14:10
 */
@Data
public class TemplateMakerConfig {

    private Long id;

    private Meta meta = new Meta();

    private String originProjectPath;

    private TemplateMakerFileConfig fileConfig = new TemplateMakerFileConfig();

    private TemplateMakerModelConfig modelConfig = new TemplateMakerModelConfig();

    private TemplateMakerOutputConfig outputConfig = new TemplateMakerOutputConfig();

}
