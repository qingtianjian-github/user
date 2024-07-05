package com.heima.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * 数据源配置
 *
 * @author cjw
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.userdb.master")
    public DataSource userdbMasterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 配置数据源
     *
     * @return
     */
    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.userdb.slave")
    public DataSource userdbSlaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源映射
     *
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        //缓存数据源
        Map<Object, Object> dataSourceMap = new HashMap<Object, Object>(2);
        dataSourceMap.put(DataSourceKey.MASTER.getName(), userdbMasterDataSource());
        dataSourceMap.put(DataSourceKey.SLAVE.getName(), userdbSlaveDataSource());
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        //设置默认数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(userdbMasterDataSource());
        //缓存数据源key
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
        return dynamicRoutingDataSource;
    }

    /**
     * sql工厂：创建sqlSession并且执行sql
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //MybatisPlus使用的是MybatisSqlSessionFactory
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        //此处设置为了解决找不到mapper文件的问题
        //sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(CLASSPATH_MAPPING_XML));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 事务管理器
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
