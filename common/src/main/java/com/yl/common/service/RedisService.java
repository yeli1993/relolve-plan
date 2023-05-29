package com.yl.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @创建人 叶立
 * @创建时间 2023/2/13
 * @描述
 */
@Component
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public String getStringValue(String key) {

        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

    public void setStringValue(String key, String value) {

        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置hash缓存
     *
     * @param key
     * @param value
     */
    public void setMapValue(String hash, String key, String value) {

        redisTemplate.opsForHash().put(hash, key, value);
    }

    public Map<Object, Object> getHashValue(String key){

        return redisTemplate.opsForHash().entries(key);
    }


}
