package com.compus;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;

/**
 * PROJECT_NAME Service
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/15~13:16
 */
@org.springframework.stereotype.Service
public class Service {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    /*
    获取task
     */
    @Async("UserThreadPool")
    public void doQueryMemoryCache() {
        //rpc 调用mysql 查库存
        stringRedisTemplate.opsForValue().set("key", "v");
    }
}
