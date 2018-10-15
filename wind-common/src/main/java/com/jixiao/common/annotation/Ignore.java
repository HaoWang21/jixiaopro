package com.jixiao.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 忽略某些属性
 * </p>
 *
 * @author jiang
 * @since 2018-06-29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {

    /**
     * 日志
     */
    boolean log() default false;
}
