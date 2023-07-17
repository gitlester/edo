package com.itmy.edo.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * 令牌桶
 * @author: limeng
 * @date: 2023/7/17 21:39
 * @version: 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface TokenBucketLimiter {
    int value() default 50;
}
