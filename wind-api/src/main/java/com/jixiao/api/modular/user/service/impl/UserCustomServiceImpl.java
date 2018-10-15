package com.jixiao.api.modular.user.service.impl;

import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.core.exception.DiyException;
import com.jixiao.api.modular.user.service.IUserCustomService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.UserCustom;
import com.jixiao.user.entity.UserDynamic;
import com.jixiao.user.mapper.IUserCustomMapper;
import com.jixiao.user.mapper.IUserDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserCustomServiceImpl implements IUserCustomService {

    @Autowired
    private IUserCustomMapper userCustomMapper;
    @Autowired
    private IUserDynamicMapper userDynamicMapper;

    @Lock4j(keys = {"#userId"}, expire = 30000, tryTimeout = 1000)
    @Transactional(rollbackFor = DiyException.class)
    @Override
    public JsonResult saveOrRemove(Long userDynamicId, Integer type, Long userId) {
        UserDynamic userDynamic = userDynamicMapper.selectById(userDynamicId);
        if (null == userDynamic) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserCustom userCustom = userCustomMapper.selectOne(new LambdaQueryWrapper<UserCustom>()
                .eq(UserCustom::getUserDynamicId, userDynamicId).eq(UserCustom::getUserId, userId)
                .eq(UserCustom::getType, type).eq(UserCustom::getDelFlag, 0));

        if (null == userCustom) {
            switch (type) {
                case 0:
                    userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 0, 1);
                    break;
                case 1:
                    userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 1, 1);
                    break;
                default:
                    return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            userCustomMapper.insert(new UserCustom.Builder().userDynamicId(userDynamicId).userId(userId).type(type).build());
        } else {
            switch (type) {
                case 0:
                    userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 0, -1);
                    break;
                case 1:
                    userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 1, -1);
                    break;
                default:
                    return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            userCustomMapper.deleteById(userCustom.getId());
        }
        return JsonResult.success();
    }
}
