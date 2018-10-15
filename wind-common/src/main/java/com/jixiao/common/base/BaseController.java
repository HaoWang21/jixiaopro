package com.jixiao.common.base;

import com.jixiao.common.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 门口杂货店
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    /**
     * 获取用户ID
     */
    protected Long getUserId() {
        Object userId = request.getSession().getAttribute(Constant.USER_ID);
        if (null == userId) {
            return null;
        }
        return (Long) userId;
    }
}
