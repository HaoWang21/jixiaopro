package com.jixiao.api.modular.tool.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.baomidou.lock.annotation.Lock4j;
import com.jixiao.api.core.DiyProperties;
import com.jixiao.api.core.enums.SmsEnum;
import com.jixiao.api.core.util.SmsUtil;
import com.jixiao.api.core.util.scan.SpringContextUtil;
import com.jixiao.api.modular.tool.service.IToolShortMessageService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.util.RandomUtil;
import com.jixiao.common.util.RequestUtil;
import com.jixiao.tool.entity.ToolShortMessage;
import com.jixiao.tool.mapper.IToolShortMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class ToolShortMessageServiceImpl implements IToolShortMessageService {

    @Autowired
    private IToolShortMessageMapper toolShortMessageMapper;

    @Lock4j(keys = {"#mobile"}, expire = 30000, tryTimeout = 1000)
    @Override
    public JsonResult save(String mobile, Integer type) {
        String templateCode;
        switch (type) {
            case 0:
                templateCode = SmsEnum.REGISTER.getCode();
                break;
            case 1:
                templateCode = SmsEnum.LOGIN.getCode();
                break;
            case 2:
                templateCode = SmsEnum.CHANGE_PASSWORD.getCode();
                break;
            case 3:
                templateCode = SmsEnum.FORGET_PASSWORD.getCode();
                break;
            default:
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        String code = RandomUtil.generateDigitalString(6);

        ToolShortMessage shortMessage = new ToolShortMessage.Builder()
                .mobile(mobile).code(code).type(type).sendIp(RequestUtil.getRemoteAddr()).status(0).build();

        boolean check = false;
        DiyProperties bean = SpringContextUtil.getBean(DiyProperties.class);
        if (bean.getShortMessageEnabled()) {
            JsonResult result = SmsUtil.send(mobile, templateCode, code);
            if (result.getCode().equals(ErrorCode.INTERNAL_SERVER_ERROR.getCode())) {
                return result;
            }
            check = ErrorCode.OK.getCode().equals(result.getCode()) && null != result.getData();
            if (check) {
                SendSmsResponse response = (SendSmsResponse) result.getData();
                shortMessage.setErrorMessage(response.getMessage());
            }
        }

        toolShortMessageMapper.insert(shortMessage);

        if (check) {
            return JsonResult.failure(ErrorCode.INTERNAL_SERVER_ERROR, "第三方短信服务异常请联系客服");
        }
        return JsonResult.success(code);
    }
}
