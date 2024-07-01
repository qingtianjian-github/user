package com.heima.config;

/**
 * 数据源key
 *
 * @author cjw
 */
public enum DataSourceKey {

    MASTER("master"),

    SLAVE("slave");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private DataSourceKey(String name) {
        this.name = name;
    }

}
