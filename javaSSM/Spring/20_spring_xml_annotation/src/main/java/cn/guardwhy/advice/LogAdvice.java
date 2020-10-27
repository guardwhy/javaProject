package cn.guardwhy.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志通知类
 * 注解说明：
 *      @Aspect：
 *          作用：声明当前类是一个切面类，相当于xml中aop:aspect标签
 *      @Before：
 *          作用：配置前置通知
 *      @AfterReturning：
 *          作用：配置后置通知
 *      @AfterThrowing：
 *          作用：配置异常通知
 *      @After：
 *          作用：配置最终通知
 *      @Pointcut：
 *          作用：配置切入点表达式
 */
@Component("logAdvice")
@Aspect
public class LogAdvice {

    /**
     * 切入点表达式
     */
    @Pointcut("execution(* cn.guardwhy.service..*.*(..))")
    public void pt1(){}

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforeLog(){
        System.out.println("[前置通知]记录用户操作日志");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public  void afterReturningLog(){
        System.out.println("【后置通知】记录用户操作日志");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public  void afterThrowingLog(){
        System.out.println("【异常通知】记录用户操作日志");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public  void afterLog(){
        System.out.println("【最终通知】记录用户操作日志");
    }

    /**
     * 环绕通知：
     *      1.它是spring框架为我们提供了手动控制通知执行时间点和顺序的一种特殊通知类型
     * 原理分析：
     *      2.spring框架提供了ProceedingJoinPoint接口，作为环绕通知的参数。在环绕通知
     *      执行的时候，spring框架会提供实例化对象，我们直接使用即可。该接口中提供了
     *      两个方法：
     *          getArgs：获取参数列表
     *          proceed：相当于反射中的invoke方法
     *
     */
     @Around("pt1()")
    public void aroundLog(ProceedingJoinPoint pjp){
        // 前置通知
        System.out.println("[环绕通知-前置通知]记录用户操作日志");

        try {
            // 获取参数列表
            Object[] args = pjp.getArgs();
            // 反射调用目标方法
            Object retv = pjp.proceed(args);
            // 后置通知
            System.out.println("[环绕通知-后置通知]记录用户操作日志");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
            System.out.println("[环绕通知-异常通知]记录用户操作日志");
        }
        // 最终通知
        System.out.println("[环绕通知-最终通知]记录用户操作日志");
    }
}
