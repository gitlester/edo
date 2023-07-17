package com.itmy.edo.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: limeng
 * @date: 2023/7/17 21:40
 * @version: 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShLimiter {
    int value() default 50;
}