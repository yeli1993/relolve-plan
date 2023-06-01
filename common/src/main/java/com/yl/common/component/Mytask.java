package com.yl.common.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @创建人 叶立
 * @创建时间 2023/6/1
 * @描述  自定义定时任务 SpringTask
 */

@Log4j2
@Configuration
@EnableScheduling
public class Mytask {

    /**
     * cron格式： 秒 分 时 日期 月份 星期几
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    public void excuteTask(){
        log.info("====================定时任务【每10分钟执行一次】========================");
    }

}
