package com.yl.test.consumer;


import com.yl.test.dao.TestDao;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

//@Component


public class KafkaConsumer {

    @Autowired
    private TestDao testDao;

    @Autowired
    private ThreadPoolExecutor kafkaConsumeThreadPool;


    //kafka的监听器，topic为"zhTest"，消费者组为"zhTestGroup"
    @KafkaListener(topics = "zhTest", groupId = "zhTestGroup")
    public void listenZhugeGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String key = record.key();
        String value = record.value();
//        Map<String,Object> value = record.value();

        try {
            Thread.sleep(1);
//            System.out.println(value);
//            System.out.println(record);

            TestDao testDao = this.testDao;
            /**
             * 问题：监听线程池队列大小控制消费速度
             */
            BlockingQueue<Runnable> queue = kafkaConsumeThreadPool.getQueue();
            System.out.println("当前队列大小："+queue.size());

            //自旋等待
            while(queue.size() >=  10){
                Thread.sleep(1000);
            }

            testDao.save(value.toString());

            //方案设计 前台批量导入 10000条 异步轮训 500条一次 后台启用线程池调用

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //手动提交offset
            ack.acknowledge();
        }


    }

    public void listenZhugeGroupBatch(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        //手动提交offset
        ack.acknowledge();
    }

        /*//配置多个消费组
    @KafkaListener(topics = "zhTest",groupId = "zhTestGroup2")
    public void listenTulingGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        ack.acknowledge();
    }*/

}
