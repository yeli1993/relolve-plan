package com.yl.common.aop;

import lombok.extern.log4j.Log4j2;
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

/**
 * @Aspect：用于定义切面
 * @Before：通知方法会在目标方法调用之前执行
 * @After：通知方法会在目标方法返回或抛出异常后执行
 * @AfterReturning：通知方法会在目标方法返回后执行
 * @AfterThrowing：通知方法会在目标方法抛出异常后执行
 * @Around：通知方法会将目标方法封装起来
 * @Pointcut：定义切点表达式
 */

@Log4j2
@Component
@Aspect
public class DataTranslateAop {

    /**
     * //com.macro.mall.tiny.controller包中所有类的public方法都应用切面里的通知
     * execution(public * com.macro.mall.tiny.controller.*.*(..))
     * //com.macro.mall.tiny.service包及其子包下所有类中的所有方法都应用切面里的通知
     * execution(* com.macro.mall.tiny.service..*.*(..))
     * //com.macro.mall.tiny.service.PmsBrandService类中的所有方法都应用切面里的通知
     * execution(* com.macro.mall.tiny.service.PmsBrandService.*(..))
     */
    @Pointcut("@annotation(com.yl.common.annotation.DataTranslate)")
    public void aopPointCut() {

    }

    @Around("aopPointCut()")
    public Object arround(ProceedingJoinPoint point) {

        Signature methodName = point.getSignature();
//        日志输出
        log.info(methodName + "进来了");
        Long l1 = System.currentTimeMillis();
//        让方法执行
        Object obj = null;
        try {
            obj = point.proceed(point.getArgs());

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info(methodName + "走了" + "\t耗时" + (System.currentTimeMillis() - l1));

        System.out.println("返回值:" + obj.toString());
        return obj;
    }
}
