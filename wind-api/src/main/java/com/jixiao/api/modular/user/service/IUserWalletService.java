package com.jixiao.api.modular.user.service;

import com.alibaba.fastjson.JSONObject;
import com.jixiao.common.JsonResult;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserWalletService {

   /**
     * 对用户钱包进行操作，记录流水
     *
     * @param userId 用户Id
     * @param json 数据组装，下面是栗子：
     * <br></br>
     * <br>        使用请慎重！！</br>
     * <br></br>
     * <br>JSONObject json = new JSONObject();</br>
     * <br>json.put(Constant.BALANCE, new BigDecimal(0));</br>
     * <br>json.put(Constant.CONSUME_COUPON, new BigDecimal(0));</br>
     * <br>json.put(Constant.GOLD_COIN, 0);</br>
     * <br>json.put(Constant.SILVER_COIN, 0);</br>
     * <br>json.put(Constant.COPPER_COIN, 0);</br>
     * <br>json.put(Constant.REMARK, String.format("注册成功，获得%s赠送积分", 100));</br>
     */
    void updateUserWalletYouHaveToBeCareful(Long userId, JSONObject json);
}
