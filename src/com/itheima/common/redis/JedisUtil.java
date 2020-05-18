package com.itheima.common.redis;

public interface JedisUtil {
    /**
     * 放入缓存
     * @param key
     * @param value
     */
    void putObject(Object key, Object value);
    /**
     * 功能描述: 放入缓存
     * @param key
     * @param value
     * @param expire 有效期,单位秒
     * @return void
     */
    void putObjectWithExpire(Object key, Object value,Integer expire);
    /**
     * 清除缓存
     * @param arg0
     * @return
     */
    Object removeObject(Object arg0);
    /**
     * 从缓存中获取
     * @param arg0
     * @return
     */
    Object getObject(Object arg0);
}
