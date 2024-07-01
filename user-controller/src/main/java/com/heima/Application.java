package com.heima;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author cjw
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("服务启动>>>开始");
        SpringApplication.run(Application.class, args);
        log.info("服务启动>>>结束");
    }
}
