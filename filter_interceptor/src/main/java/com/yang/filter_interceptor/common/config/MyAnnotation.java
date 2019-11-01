package com.yang.filter_interceptor.common.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})//作用于方法和类
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Inherited//是一个元注解，允许其他注解继承它
@Documented//生成javadoc时会包含注解
public @interface MyAnnotation {
    String value();
}
