package com.jixiao.api.modular.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.modular.user.service.IUserPrivacySettingsService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.enums.UserPrivacySettingsEnum;
import com.jixiao.common.util.StringUtil;
import com.jixiao.user.entity.UserAddress;
import com.jixiao.user.entity.UserPrivacySettings;
import com.jixiao.user.entity.vo.UserPrivacySettingsDetailsVO;
import com.jixiao.user.mapper.IUserPrivacySettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @since 2018-10-01
 */
@Service
public class UserPrivacySettingsServiceImpl implements IUserPrivacySettingsService {

    @Autowired
    private IUserPrivacySettingsMapper userPrivacySettingsMapper;

    @Override
    public JsonResult update(UserPrivacySettingsDetailsVO vo, Long userId) {
        UserPrivacySettings userPrivacySettings = userPrivacySettingsMapper.selectOne(new LambdaQueryWrapper<UserPrivacySettings>()
                .eq(UserPrivacySettings::getUserId, userId).eq(UserPrivacySettings::getDelFlag, 0));

        // 创建一个空的隐私
        UserPrivacySettings.Builder builder = new UserPrivacySettings.Builder().id(userPrivacySettings.getId());

        if (StringUtil.isNotBlank(vo.getComment())) {
            if (UserPrivacySettingsEnum.UNKNOWN.getValue().equals(UserPrivacySettingsEnum.getKey(vo.getComment()).getValue())) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            userPrivacySettingsMapper.updateById(builder.comment(vo.getComment()).build());
            return JsonResult.success();
        }

        if (null != vo.getLocation()) {
            userPrivacySettingsMapper.updateById(builder.location(vo.getLocation()).build());
            return JsonResult.success();
        }

        if (StringUtil.isNotBlank(vo.getAte())) {
            if (UserPrivacySettingsEnum.UNKNOWN.getValue().equals(UserPrivacySettingsEnum.getKey(vo.getAte()).getValue())) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            userPrivacySettingsMapper.updateById(builder.ate(vo.getAte()).build());
            return JsonResult.success();
        }

        if (StringUtil.isNotBlank(vo.getLetter())) {
            if (UserPrivacySettingsEnum.UNKNOWN.getValue().equals(UserPrivacySettingsEnum.getKey(vo.getLetter()).getValue())) {
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            userPrivacySettingsMapper.updateById(builder.letter(vo.getLetter()).build());
            return JsonResult.success();
        }
        return JsonResult.failure(ErrorCode.BAD_REQUEST);
    }

    @Override
    public JsonResult<UserPrivacySettingsDetailsVO> details(Long userId) {
        UserPrivacySettings userPrivacySettings = userPrivacySettingsMapper.selectOne(new LambdaQueryWrapper<UserPrivacySettings>()
                .eq(UserPrivacySettings::getUserId, userId).eq(UserPrivacySettings::getDelFlag, 0));

        UserPrivacySettingsDetailsVO vo = new UserPrivacySettingsDetailsVO();
        vo.setComment(userPrivacySettings.getComment());
        vo.setLocation(userPrivacySettings.getLocation());
        vo.setAte(userPrivacySettings.getAte());
        vo.setLetter(userPrivacySettings.getLetter());
        return JsonResult.success(vo);
    }
}
