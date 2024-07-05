package com.heima.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 动态数据源切面类：通过对方法进行代理添加数据源
 *
 * @author cjw
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    /**
     * 只要包含这个注解都要拦截
     *
     * @param joinPoint
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource)")
    public void switchDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.name())) {
            log.error("DataSource {} doesn't exist, use default DataSource {}", targetDataSource.name(), DataSourceKey.MASTER.getName());
        } else {
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.name());
            log.info("Switch DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
        }
    }

    /**
     * 只要包含这个注解都要拦截
     *
     * @param joinPoint
     * @param targetDataSource
     */
    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
    }
}
