package com.heima.config;


import java.lang.annotation.*;

/**
 * 该注解只是作用在方法上，这里默认的数据源是master
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name() default "master";

}
