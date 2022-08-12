package com.tcl.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 创建切面
 *  1.在切面中，需要指定的注解将方法标识为通知方法
 *   @Before 前置通知，在目标对象方法执行前执行
 *
 *   @After  后置通知,在被代理的目标方法最终结束后执行（盖棺定论）finally
 *
 *   @AfterReturning 返回通知，在被代理的目标方法成功结束后执行（寿终正寝）（有异常不会执行）
 *      returning: 获取方法返回值结果----->
 *      通过returning属性,将通知方法的某个参数指定为接收目标对象方法的返回值的参数
 *
 *   @AfterThrowing 异常通知
 *      throwing：得到异常信息
 *
 *   @Around 环绕通知
 *      使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
 *
 *  2.切入点表达式，设置在标识通知注解的value属性中
 *   execution() 可以用*号代替“权限修饰符”和“返回值”部
 *
 *  3.重用公共切入点表达式
 *      @Pointcut     public void pointCut(){}
 *      使用方式：    @Before("pointCut()")
 *
 *  4.获取连接点信息
 *  在通知方法的参数位置，设置 JoinPoint，即可获取连接点对应方法的信息
 *      签名信息：方法名，访问修饰符，参数
 *  5.
 *
 */
@Component  //注解保证这个切面类能够放入IOC容器
@Aspect   //将当前组件标识为切面类
public class LogAspect {

    // 切入点表达式重用
    @Pointcut("execution(* com.tcl.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    // 目标对象方法执行之前执行
//    @Before("execution(public int com.tcl.spring.aop.annotation.CalculatorImpl.add(int, int))")
//    @Before("execution(* com.tcl.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        // 获取连接点对应的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LogAspect-》前置通知,方法:"+signature.getName()+" 参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        // 获取签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LogAspect-》后置通知, 方法："+signature.getName()+", 执行完毕");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        // 获取签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LogAspect-》返回通知, 方法："+signature.getName()+"，结果="+result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex){
        // 获取签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LogAspect-》异常通知, 方法："+signature.getName()+"，异常: "+ex);
    }

    // 环绕通知
//    @Around("pointCut()")
//    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
//        Object result = null;
//        try {
//            System.out.println("环绕通知--->前置通知");
//            // 表示目标对象方法的执行
//            result = joinPoint.proceed();
//            System.out.println("环绕通知--->返回通知");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            System.out.println("环绕通知--->异常通知");
//        } finally {
//            System.out.println("环绕通知--->后置通知");
//        }
//        return result;
//    }
}
