package com.heima.config;

import com.heima.slave.user.UserMapperReaderDao;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean配置类
 *
 * @author cjw
 */
@EnableConfigurationProperties(AutoConfigureProperties.class)
@Configuration
public class BeanConfiguration {

    /**
     * 用户查询
     *
     * @return
     */
    @Bean
    public UserMapperReaderDao userMapperReaderDao() {
        return new UserMapperReaderDao();
    }
}
