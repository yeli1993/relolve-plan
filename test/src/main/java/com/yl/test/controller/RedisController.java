package com.yl.test.controller;

import com.yl.common.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.util.RamUsageEstimator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @创建人 叶立
 * @创建时间 2023/2/13
 * @描述
 */

@Api(tags = "RedisController", description = "redis服务类",value = "redis服务类value")
@RestController
@RequestMapping(path = "/")
public class RedisController {
    @Autowired
    private RedisService redisService;


    @ApiOperation(value = "redis插入")
    @RequestMapping("/testRedisGet")
    public String testRedisGet() {

        String hash = "data_map";
        String key = "key";
        String value = "value";


        for (int i = 0; i < 1000; i++) {    //要素大小
            for (int j = 0; j < 100; j++) { //要素编码
                for (int k = 2020; k < 2024; k++) { //年份
                    String tempKey = k + "_" + j + "_" + i + "_" + key;
                    String tempValue = k + "_" + j + "_" + i + "_" + value;
                    redisService.setMapValue(hash, tempKey, tempValue);
                    System.out.println("插入:"+tempKey);
                }
            }
        }

        System.out.println("插入完毕");
        long start = System.currentTimeMillis();

        Map<Object,Object> rs = redisService.getHashValue(hash);

        String hs = "耗时:"+(System.currentTimeMillis() - start)+"毫秒！";
        System.out.println(hs);

        return hs;
    }

    @RequestMapping("/getRedisObjectSize")
    public String getRedisObjectSize(){

        String hash = "data_map";
        Map<Object,Object> rs = redisService.getHashValue(hash);

//计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long s1 = RamUsageEstimator.sizeOf(rs)/1024/1024;

//计算指定对象本身在堆空间的大小，单位字节
        long s2 = RamUsageEstimator.shallowSizeOf(rs);

//计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String s3 = RamUsageEstimator.humanSizeOf(rs);
        String str = "对象及其引用树上的所有对象的综合大小:"+s1+" MB" +"\n\t"+"堆空间的大小:"+s2+" B\n\t"+"对象及其引用树上的所有对象的综合大小:"+s3;

        return str;
    }
}
