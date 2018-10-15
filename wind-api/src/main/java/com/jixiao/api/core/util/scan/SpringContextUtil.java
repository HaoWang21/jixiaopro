package com.jixiao.api.core.util.scan;

import com.jixiao.api.core.DiyProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 获取Spring ApplicationContext
 * </p>
 *
 * @author jiang
 * @since 2018-07-02
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {


    private static ApplicationContext context = null;

    private SpringContextUtil() {
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtil.context == null) {
            SpringContextUtil.context = applicationContext;
        }

        DiyProperties bean = getBean(DiyProperties.class);
        System.out.println("┏-----------------------------------------┓");
        System.out.println("┆    Tips");
        System.out.println("┆");
        System.out.println("┆      ├ swagger：" + bean.getSwagger2Enabled());
        System.out.println("┆      └ short_message：" + bean.getShortMessageEnabled());
        System.out.println("┆");
        System.out.println("┗----------SpringContextUtil.java---------┛");
    }

    /**
     * 根据一个bean的name获取配置文件中相应的bean
     */
    public static Object getBean(String name) {
        if (context.containsBean(name)) {
            context.getBean(name);
        }
        return null;
    }

    /**
     * 根据一个bean的name获取指定类型bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    /**
     * 根据一个bean的类型获取配置文件中相应的bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     */
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 是否是单例
     */
    public static boolean isSingleton(String name) {
        return context.isSingleton(name);
    }

    /**
     * bean的类型
     */
    public static Class getType(String name) {
        return context.getType(name);
    }
}
