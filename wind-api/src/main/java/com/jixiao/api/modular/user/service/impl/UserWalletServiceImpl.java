package com.jixiao.api.modular.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.modular.user.service.IUserWalletService;
import com.jixiao.common.global.Constant;
import com.jixiao.user.entity.UserWallet;
import com.jixiao.user.entity.UserWalletStream;
import com.jixiao.user.mapper.IUserWalletMapper;
import com.jixiao.user.mapper.IUserWalletStreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserWalletServiceImpl implements IUserWalletService {

    @Autowired
    private IUserWalletMapper userWalletMapper;
    @Autowired
    private IUserWalletStreamMapper userWalletStreamMapper;

    @Lock4j(keys = {"#userId"}, expire = 30000, tryTimeout = 1000)
    @Override
    public void updateUserWalletYouHaveToBeCareful(Long userId, JSONObject json) {
        // 查询用户钱包
        UserWallet userWallet = userWalletMapper.selectOne(new LambdaQueryWrapper<UserWallet>()
                .eq(UserWallet::getUserId, userId).eq(UserWallet::getDelFlag, 0));

        // 创建一个空钱包
        UserWallet.Builder emptyWalletBuilder = new UserWallet.Builder().id(userWallet.getId());
        // 组装流水
        UserWalletStream.Builder streamBuilder = new UserWalletStream.Builder().userId(userId).remark(json.getString(Constant.REMARK));

        //  余额
        if (null != json.getBigDecimal(Constant.BALANCE)) {
            BigDecimal balance = json.getBigDecimal(Constant.BALANCE);
            streamBuilder.beforeBalance(userWallet.getBalance()).balance(balance).checkBalance(true);

            emptyWalletBuilder.balance(userWallet.getBalance().add(balance));
        }
        // 消费券
        if (null != json.getBigDecimal(Constant.CONSUME_COUPON)) {
            BigDecimal consumeCoupon = json.getBigDecimal(Constant.CONSUME_COUPON);
            streamBuilder.beforeConsumeCoupon(userWallet.getConsumeCoupon()).consumeCoupon(consumeCoupon).checkConsumeCoupon(true);

            emptyWalletBuilder.consumeCoupon(userWallet.getConsumeCoupon().add(consumeCoupon));
        }
        // 金币
        if (null != json.getInteger(Constant.GOLD_COIN)) {
            Integer goldCoin = json.getInteger(Constant.GOLD_COIN);
            streamBuilder.beforeGoldCoin(userWallet.getGoldCoin()).goldCoin(goldCoin).checkGoldCoin(true);

            emptyWalletBuilder.goldCoin(userWallet.getGoldCoin() + goldCoin);
        }
        // 银币
        if (null != json.getInteger(Constant.SILVER_COIN)) {
            Integer silverCoin = json.getInteger(Constant.SILVER_COIN);
            streamBuilder.beforeSilverCoin(userWallet.getSilverCoin()).silverCoin(silverCoin).checkSilverCoin(true);

            emptyWalletBuilder.silverCoin(userWallet.getSilverCoin() + silverCoin);
        }
        // 铜币
        if (null != json.getInteger(Constant.COPPER_COIN)) {
            Integer copperCoin = json.getInteger(Constant.COPPER_COIN);
            streamBuilder.beforeCopperCoin(userWallet.getCopperCoin()).copperCoin(copperCoin).checkCopperCoin(true);

            emptyWalletBuilder.copperCoin(userWallet.getCopperCoin() + copperCoin);
        }

        // 添加流水
        userWalletStreamMapper.insert(streamBuilder.build());
        // 更新钱包
        userWalletMapper.updateById(emptyWalletBuilder.build());
    }
}
