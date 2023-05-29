package com.yl.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @创建人 叶立
 * @创建时间 2022/9/4
 * @描述
 */

@Component
@Aspect
public class DataTranslateAop {

    @Pointcut("@annotation(com.yl.common.annotation.DataTranslate)")
    public void aopPointCut() {

    }

    @Around("aopPointCut()")
    public Object arround(ProceedingJoinPoint point) {

        Signature methodName = point.getSignature();
//        日志输出
//        log.info(methodName+"进来了");
        Long l1 = System.currentTimeMillis();
//        让方法执行
        Object obj = null;
        try {
            obj = point.proceed(point.getArgs());


        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
//        log.info(methodName+"走了"+"\t耗时"+(System.currentTimeMillis()-l1));

        System.out.println("返回值:" + obj.toString());
        return obj;
    }
}
