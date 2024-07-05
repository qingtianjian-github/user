package com.heima.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态路由数据源
 *
 * @author cjw
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 在访问数据库时会调用该类的 determineCurrentLookupKey() 方法获取数据库实例的 key
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("current datasource is : {}", DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}
