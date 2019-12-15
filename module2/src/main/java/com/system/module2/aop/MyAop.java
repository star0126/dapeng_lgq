package com.system.module2.aop;

import java.lang.annotation.*;

/**
 * @program: dapeng_lgq
 * @since:JDK-1.8
 * @author: Star-GuoqingLi
 * @create: 2019-12-16 00:26
 * @version:第1版
 * @description: AOP注解类
 **/
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface MyAop {
    String value() default "";
}
