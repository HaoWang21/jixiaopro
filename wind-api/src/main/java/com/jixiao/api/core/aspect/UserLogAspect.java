package com.jixiao.api.core.aspect;

import com.jixiao.api.core.annotation.RequireUser;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.annotation.Ignore;
import com.jixiao.common.base.BaseAspect;
import com.jixiao.common.global.Constant;
import com.jixiao.common.util.RequestUtil;
import com.jixiao.user.entity.UserLog;
import com.jixiao.user.mapper.IUserLogMapper;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 日志切面
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
@Aspect
@Component
public class UserLogAspect extends BaseAspect {

    @Autowired
    private IUserLogMapper userLogMapper;

    /**
     * 处理日志 线程绑定
     */
    private static final ThreadLocal<UserLog> DEAL_LOG_THREAD_LOCAL = new NamedThreadLocal<>("ThreadLocal DealLog");

    /**
     * 用@Pointcut来注解一个切入方法
     */
    @Pointcut("execution(public * com.jixiao.api.modular.*.controller.*.*(..))")
    public void log() {

    }

    /**
     * 在切入点开始处切入内容
     */
    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint) {
        if (checkIgnore(joinPoint)) {
            return;
        }

        HttpServletRequest request = RequestUtil.getRequest();
        ApiOperation apiOperation = getMethodAnnotation(joinPoint, ApiOperation.class);

        Object userId = request.getSession().getAttribute(Constant.USER_ID);

        DEAL_LOG_THREAD_LOCAL.set(
                new UserLog.Builder()
                        .requestUri(request.getRequestURI())
                        .param(getParameterByFieldsName(joinPoint))
                        .httpMethod(request.getMethod())
                        .deviceType(RequestUtil.getDeviceType())
                        .createIp(RequestUtil.getRemoteAddr())
                        .operation(apiOperation.value())
                        .userId(null == userId ? null : (Long) userId)
                        .executionTime(System.currentTimeMillis())
                        .build());
    }

    /**
     * 在切入点return内容之后切入内容
     */
    @AfterReturning(pointcut = "log()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, JsonResult result) {
        if (checkIgnore(joinPoint)) {
            return;
        }

        UserLog userLog = DEAL_LOG_THREAD_LOCAL.get();
        userLog.setResponseStatus(result.getCode());
        if (!ErrorCode.OK.getCode().equals(result.getCode())) {
            userLog.setErrorMessage(result.getMsg());
        }
        userLog.setExecutionTime(System.currentTimeMillis() - userLog.getExecutionTime());
        userLogMapper.insert(userLog);

        DEAL_LOG_THREAD_LOCAL.remove();
    }

    /**
     * 用来处理当切入内容部分抛出异常之后的处理逻辑
     */
    @AfterThrowing(pointcut = "log()", throwing = "th")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable th) {
        if (checkIgnore(joinPoint)) {
            return;
        }

        UserLog userLog = DEAL_LOG_THREAD_LOCAL.get();
        userLog.setResponseStatus(500);
        userLog.setErrorMessage(th.toString());
        userLog.setExecutionTime(System.currentTimeMillis() - userLog.getExecutionTime());
        userLogMapper.insert(userLog);

        DEAL_LOG_THREAD_LOCAL.remove();
    }

    private boolean checkIgnore(JoinPoint joinPoint) {
        // 忽略不需要登录状态的接口
        boolean requireUser = require(joinPoint, RequireUser.class);
        if (!requireUser) {
            return true;
        }
        boolean require = require(joinPoint, Ignore.class);
        if (!require) {
            return false;
        }
        Ignore classIgnore = getClassAnnotation(joinPoint, Ignore.class);
        Ignore methodIgnore = getMethodAnnotation(joinPoint, Ignore.class);
        return null != classIgnore && classIgnore.log() || null != methodIgnore && methodIgnore.log();
    }
}
