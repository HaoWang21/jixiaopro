package com.jixiao.api.core.util;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jixiao.api.core.DiyProperties;
import com.jixiao.api.core.util.scan.SpringContextUtil;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.global.Constant;

/**
 * <p>
 * 短信服务工具
 * 文档：https://help.aliyun.com/product/44282.html?spm=a2c4g.11186623.6.539.4bd315e8dmbfiJ
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class SmsUtil {

    /**
     * 发送短信
     * @param mobile 手机号
     * @param templateCode 模板编号
     * @param code 验证码
     * @return json
     */
    public static JsonResult send(String mobile, String templateCode, String code) {
        DiyProperties bean = SpringContextUtil.getBean(DiyProperties.class);

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", bean.getMessageAccessKeyId(), bean.getMessageAccessKeySecret());
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。
            request.setPhoneNumbers(mobile);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("极效科技");
            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam("{\"code\":\"" + code + "\"}");

            //请求失败这里会抛ClientException异常
            SendSmsResponse response = acsClient.getAcsResponse(request);

            if (null != response.getCode() && !Constant.SMS_OK.equals(response.getCode())) {
                return JsonResult.success(response);
            }

            return JsonResult.success();
        } catch (ClientException e) {
            return JsonResult.failure(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}