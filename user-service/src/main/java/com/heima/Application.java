package com.heima;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 *
 * @author cjw
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.heima"})
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("服务启动>>>开始");
        SpringApplication.run(Application.class, args);
        log.info("服务启动>>>结束");
    }
}
