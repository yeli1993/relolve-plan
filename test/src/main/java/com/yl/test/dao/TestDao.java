package com.yl.test.dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @创建人 叶立
 * @创建时间 2022/10/11
 * @描述
 */
@EnableAsync
@Repository
public class TestDao {

    private Map<String, Object> concurrenthashMap = new ConcurrentHashMap<>();

    @Async("kafkaConsumeThreadPool")
    public void save(String s) {

        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "_值____" + s + "    ：保存成功！");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "_值____" + s + "    ：保存失败！");
        }

    }

    @Async("kafkaConsumeThreadPool")
    public void testConcurrentHashMap(String key,String value) {

        concurrenthashMap.put(key,value);

    }
}
