package com.jixiao.common.base;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <p>
 * 切面杂货店
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class BaseAspect {

    /**
     * 判断方法上或者类上是否加了某个注解
     */
    protected boolean require(JoinPoint joinPoint, Class<? extends Annotation> annotationClass) {
        Method method = getMethodSignature(joinPoint).getMethod();
        return method.isAnnotationPresent(annotationClass)
                || method.getDeclaringClass().isAnnotationPresent(annotationClass);
    }

    /**
     * 获取类上的注解
     */
    protected <T extends Annotation> T getClassAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
        return getMethodSignature(joinPoint).getMethod().getDeclaringClass().getAnnotation(annotationClass);
    }

    /**
     * 获取方法上的注解
     */
    protected <T extends Annotation> T getMethodAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
        return getMethodSignature(joinPoint).getMethod().getAnnotation(annotationClass);
    }

    /**
     * 通过反射机制 获取被切参数名以及参数值
     */
    protected String getParameterByFieldsName(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();
        try {
            ClassPool classPool = ClassPool.getDefault();
            // 类
            ClassClassPath classPath = new ClassClassPath(joinPoint.getClass());
            classPool.insertClassPath(classPath);
            // 类名
            CtClass ctClass = classPool.get(getMethodSignature(joinPoint).getDeclaringTypeName());
            // 方法名
            CtMethod ctMethod = ctClass.getDeclaredMethod(getMethodSignature(joinPoint).getName());
            MethodInfo methodInfo = ctMethod.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;

            Object[] args = joinPoint.getArgs();
            boolean first = true;
            for (int i = 0; i < ctMethod.getParameterTypes().length; i++) {
                if (!first) {
                    builder.append("&");
                }

                String variableName = attr.variableName(i + pos);
                if (variableName.toLowerCase().contains("password")) {
                    args[i] = "■■■■■■";
                }

                builder.append(variableName).append("=").append(args[i]);
                first = false;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private MethodSignature getMethodSignature(JoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }
}
