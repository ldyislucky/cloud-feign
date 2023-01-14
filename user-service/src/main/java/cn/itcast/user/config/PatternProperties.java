package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : ldy
 * @version : 1.0
 */
@Data
@Component
//pattern  +  dateformat  拼接起来与nacos中的配置串名称一致就可以拿到nacos的配置
@ConfigurationProperties(prefix = "pattern")//有在类上注解@RefreshScope的功能，管理配置的热更新
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
}
