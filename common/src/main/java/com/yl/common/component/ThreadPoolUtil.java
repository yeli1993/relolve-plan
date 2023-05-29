package com.yl.common.component;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 线程池工具类
 */
@Component
@EnableAsync
public class ThreadPoolUtil {

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    private int maximumPoolSize = Runtime.getRuntime().availableProcessors();
    private long keepAliveTime = 1000l;
    private TimeUnit unit = TimeUnit.SECONDS;


    @Bean("kafkaConsumeThreadPool")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                new ArrayBlockingQueue<>(10));
    }


}
