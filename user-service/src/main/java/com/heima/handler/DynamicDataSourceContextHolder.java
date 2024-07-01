package com.heima.handler;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源控制器
 *
 * @author cjw
 */
public class DynamicDataSourceContextHolder {
    //当前线程持有的数据源
    private static ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.MASTER::getName);
    //缓存数据源key
    public static List<Object> dataSourceKeys = new ArrayList<Object>();

    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }

    /**
     * 数据源key
     *
     * @return
     */
    public static Object getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源key
     */
    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 是否包含数据源
     *
     * @param key
     * @return
     */
    public static Boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}
