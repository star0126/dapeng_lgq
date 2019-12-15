package com.system.module2.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: dapeng_lgq
 * @since:JDK-1.8
 * @author: Star-GuoqingLi
 * @create: 2019-12-16 00:29
 * @version:第1版
 * @description: 切面处理
 **/
@Aspect
@Component
public class AopAspect {


    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.system.module2.aop.MyAop)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        AopLog aopLog = new AopLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyAop myLog = method.getAnnotation(MyAop.class);
        if (myLog != null) {
            String value = myLog.value();
            aopLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        aopLog.setMethod(className + "." + methodName);
        //时间
        aopLog.setCreateDate(new Date());
        System.out.println(aopLog.getCreateDate()+"用户进行的操作是："+aopLog.getOperation()+
                ",方法是："+aopLog.getMethod());


    }

}
