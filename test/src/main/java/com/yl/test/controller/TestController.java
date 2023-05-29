package com.yl.test.controller;

import com.yl.common.annotation.DataTranslate;
import com.yl.test.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @创建人 叶立
 * @创建时间 2022/9/4
 * @描述
 */

@RestController
@RequestMapping(path = "/")
public class TestController {

    private Logger loger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private TestDao testDao;

    private static final String TOPIC_NAME = "zhTest";
    private int invokeTimes = 1;    //调用次数

    /**
     * 自定义注解切点实现数据拦截处理
     * @return
     */
    @DataTranslate
    @PostMapping(value = "/api/getDataList")
    public List<Map<String,Object>> getDataList(){
        List<Map<String,Object>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> obj = new HashMap<>();
            obj.put(i+"code",i+"code");
            result.add(obj);
        }
        return result;
    }

    /**
     * kafka消息发送
     * @return
     */
    @RequestMapping("/send")
    public String productMes() {
        int start = (invokeTimes - 1) * 500 + 1;
        int end = invokeTimes * 500;

        String rs = "开始值：" + start + "结束值："+end;
        loger.info(rs);

        //topic, partition, key,datas
        for (int i = start; i <= end; i++) {
//            Map<String,Object> data = new HashMap<>();
//            data.put("key",i);
//            data.put("value","hello_________" + i);
            kafkaTemplate.send(TOPIC_NAME, "key", "hello_________" + i);
//            kafkaTemplate.send(TOPIC_NAME, "key", data);
        }
        invokeTimes ++;
        return "发送成功！" + rs;
    }


    @RequestMapping("/testConcurrentHashMap")
    public String testConcurrentHashMap(){

        for (int i = 0; i < 10; i++) {
            testDao.testConcurrentHashMap("test",String.valueOf(i));

        }

        return "发送成功！";
    }

}
