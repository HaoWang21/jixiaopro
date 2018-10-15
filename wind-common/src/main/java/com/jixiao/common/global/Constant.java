package com.jixiao.common.global;

/**
 * <p>
 * 自定义常量
 * </p>
 *
 * @author jiang
 * @since 2018-07-17
 */
public class Constant {

    /**
     * 系统默认配置主键（动了拖出去祭天！）
     */
    public static final String API_CONFIG = "cache:api_config";
    public static final String BACKDROP_URL = "backdrop_url";
    public static final String AVATAR_CASE_URL = "avatar_case_url";
    public static final String AVATAR_URL = "avatar_url";
    public static final String REGISTER = "register";
    public static final String REFEREE_REGISTER = "referee_register";
    public static final String REGISTRATIONS = "registrations";

    /**
     * 钱包操作主键（动了拖出去祭天！）
     */
    public static final String BALANCE = "balance";
    public static final String CONSUME_COUPON = "consume_coupon";
    public static final String GOLD_COIN = "gold_coin";
    public static final String SILVER_COIN = "silver_coin";
    public static final String COPPER_COIN = "copper_coin";
    public static final String REMARK = "remark";


    public static final String INDEX_LABEL = "cache:index:label";
    public static final String INDEX_BANNER = "cache:index:banner";


    /**
     * header cookie key
     */
    public static final String COOKIE_KEY = "JSESSIONID";
    public static final Integer COOKIE_EXPIRE = 7 * 24 * 60 * 60;

    /**
     * user attribute key
     */
    public static final String USER_ID = "userId";
    /**
     * 验证码五分钟失效
     */
    public static final Integer SMS_EXPIRE = 5;
    public static final String SMS_OK = "OK";
    /**
     * 最大连续签到天数
     */
    public static final Integer MAX_SIGN_IN_DAT = 30;
    /**
     * 缓存主键前缀
     */
    public static final String KICK_OUT_KEY = "kick_out:";
}
