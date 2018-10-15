package com.jixiao.api.core.interceptor;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.api.core.exception.DiyException;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.global.Constant;
import com.jixiao.common.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Deque;

/**
 * <p>
 * 全局拦截器
 * </p>
 *
 * @author jiang
 * @since 2017-12-08
 */
public class GlobalInterceptorHandler implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalInterceptorHandler.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 处理时间 线程绑定
     */
    private static final ThreadLocal<Long> DEAL_TIME_THREAD_LOCAL = new NamedThreadLocal<>("ThreadLocal DealTime");

    @Override
    @SuppressWarnings(value = "unchecked")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            System.out.println();
            DEAL_TIME_THREAD_LOCAL.set(System.currentTimeMillis());
            LOG.debug("{} uri: {}", request.getMethod(), request.getRequestURI());

            HttpSession session = request.getSession();
            if (require(handler, RequireUser.class)) {
                Object userId = session.getAttribute(Constant.USER_ID);
                if (null == userId) {
                    throw new DiyException(ErrorCode.UNAUTHORIZED.getCode(), "请先登录");
                }

                // 检测是否被踢出
                ValueOperations<String, Deque<Serializable>> opsForValue = redisTemplate.opsForValue();
                Deque<Serializable> deque = opsForValue.get(Constant.KICK_OUT_KEY + Md5Util.md5(userId.toString()));
                if (null != deque && !deque.contains(session.getId())) {
                    throw new DiyException(ErrorCode.UNAUTHORIZED.getCode(), "该账号在别处登陆请重新登录");
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOG.debug("times: {}ms", System.currentTimeMillis() - DEAL_TIME_THREAD_LOCAL.get());
        DEAL_TIME_THREAD_LOCAL.remove();
    }

    /**
     * 判断方法上或者类上是否加了某个注解
     */
    private boolean require(Object handler, Class<? extends Annotation> annotationClass) {
        Method method = ((HandlerMethod) handler).getMethod();
        return method.isAnnotationPresent(annotationClass) || method.getDeclaringClass().isAnnotationPresent(annotationClass);
    }
}