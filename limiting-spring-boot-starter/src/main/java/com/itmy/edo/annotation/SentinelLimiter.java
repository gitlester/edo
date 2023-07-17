package com.itmy.edo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: limeng
 * @date: 2023/7/17 21:41
 * @version: 1.0.0
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SentinelLimiter {

    String resourceName();

    int limitCount() default 50;

}
