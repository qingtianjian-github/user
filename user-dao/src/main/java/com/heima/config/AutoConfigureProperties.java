package com.heima.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author cjw
 */
@ConfigurationProperties(prefix = "com.heima")
public class AutoConfigureProperties {


}
