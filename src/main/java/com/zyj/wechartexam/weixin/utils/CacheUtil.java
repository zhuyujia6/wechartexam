package com.zyj.wechartexam.weixin.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public final class CacheUtil{
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 缓存取值
     * @param key
     * @return
     */
    public String getCacheValue(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 缓存赋值
     * @param key
     * @param value
     */
    public void setCacheValue(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public void delCacheValue(String key) {
        this.redisTemplate.delete(key);
    }

    /**
     * 缓存赋值并设置有效时间
     * @param key
     * @param value
     * @param number 数据
     * @param unit   例如：TimeUnit.DAYS
     */
    public void setCacheValue(String key, String value, long number, TimeUnit unit) {
        this.redisTemplate.opsForValue().set(key, value, number, unit);
    }

    /**
     * 获取有效期
     *
     * @param key
     */
    public void getExpireTime(String key) {
        this.redisTemplate.getExpire(key);
    }

    /**
     * 通过 TimeUnit 获取有效期
     * @param key
     * @param unit
     */
    public void getExpireTime(String key, TimeUnit unit) {
        this.redisTemplate.getExpire(key, unit);
    }

    /**
     * 获取指定条件key值
     * @param pattern *:所有
     * @return
     */
    public Set<String> getCacheKeys(String pattern) {
        return this.redisTemplate.keys(pattern);
    }
}


