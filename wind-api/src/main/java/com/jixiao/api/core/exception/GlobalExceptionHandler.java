package com.jixiao.api.core.exception;

import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author jiang
 * @since 2017-12-08
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private HttpServletRequest request;

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public JsonResult handleBadRequest(Exception exp) {
        /*
         * 自定义异常
         */
        if (exp instanceof DiyException) {
            DiyException diy = (DiyException) exp;
            return JsonResult.failure(diy.getCode(), diy.getMsg());
        }

        loggerError(exp);

        /*
         * 参数校验异常
         */
        if (exp instanceof BindException) {
            BindingResult bindingResult = ((BindException) exp).getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError fieldError = bindingResult.getFieldErrors().stream().findFirst().get();
                return JsonResult.failure(ErrorCode.BAD_REQUEST, fieldError.getField() + fieldError.getDefaultMessage());
            }
        }
        /*
         * 系统内部异常
         */
        return JsonResult.failure(ErrorCode.INTERNAL_SERVER_ERROR, getMessage(exp));
    }

    /**
     * 打印异常信息
     */
    private void loggerError(Exception exp) {
        LOG.error("status: {}", getStatus());
        LOG.error("exception: {}", getMessage(exp));
        exp.printStackTrace();
    }

    /**
     * 获取错误信息
     */
    private String getMessage(Exception exp) {
        return null == exp.getMessage() ? exp.toString() : exp.getMessage();
    }

    /**
     * 获取错误编码
     */
    private HttpStatus getStatus() {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
