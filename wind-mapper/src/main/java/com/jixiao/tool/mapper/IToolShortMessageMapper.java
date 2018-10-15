package com.jixiao.tool.mapper;

import com.jixiao.tool.entity.ToolShortMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IToolShortMessageMapper extends BaseMapper<ToolShortMessage> {

    /**
     * 查询短信记录
     *
     * @param mobile 手机号
     * @param code 验证码
     * @param type 类型
     * @param status 状态
     * @return obj
     */
    ToolShortMessage selectByMobileAndOtherAttribute(@Param("mobile") String mobile, @Param("code") String code,
                                                     @Param("type") Integer type, @Param("status") Integer status);

}
