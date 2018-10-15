package com.jixiao.api.modular.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.core.util.OssUtil;
import com.jixiao.api.modular.user.service.IUserInfoService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.util.StringUtil;
import com.jixiao.user.entity.UserInfo;
import com.jixiao.user.entity.dto.UserInfoUpdateDTO;
import com.jixiao.user.mapper.IUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author jiang
 * @since 2018-09-29
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoMapper userInfoMapper;

    @Override
    public JsonResult update(UserInfoUpdateDTO dto, Long userId) {
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId, userId).eq(UserInfo::getDelFlag, 0));

        UserInfo.Builder builder = new UserInfo.Builder().id(userInfo.getId());

        if (StringUtil.isNotBlank(dto.getBackdropUrl())) {
            userInfoMapper.updateById(builder.backdropUrl(dto.getBackdropUrl()).build());
            return JsonResult.success();
        }

        if (StringUtil.isNotBlank(dto.getAvatarCaseUrl())) {
            userInfoMapper.updateById(builder.avatarCaseUrl(dto.getAvatarCaseUrl()).build());
            return JsonResult.success();
        }

        if (StringUtil.isNotBlank(dto.getNickName())) {
            userInfoMapper.updateById(builder.nickName(StringUtil.encodeBase64String(dto.getNickName())).build());
            return JsonResult.success();
        }

        if (StringUtil.isNotBlank(dto.getAvatarUrl())) {
            userInfoMapper.updateById(builder.avatarCaseUrl(dto.getAvatarUrl()).build());
            return JsonResult.success();
        }

        if (null != dto.getGender()) {
            userInfoMapper.updateById(builder.gender(dto.getGender()).build());
            return JsonResult.success();
        }

        if (null != dto.getProvinceId() && null != dto.getAddress()) {
            builder.provinceToolDistrictId(dto.getProvinceId()).address(dto.getAddress());
            if (null != dto.getCityId()) {
                builder.cityToolDistrictId(dto.getCityId());
            }
            if (null != dto.getAreaId()) {
                builder.areaToolDistrictId(dto.getAreaId());
            }
            userInfoMapper.updateById(builder.build());
            return JsonResult.success();
        }
        return JsonResult.failure(ErrorCode.BAD_REQUEST);
    }

    @Override
    public JsonResult updateImage(MultipartFile file, Integer type, Long userId) {
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId, userId).eq(UserInfo::getDelFlag, 0));

        if (null == userInfo) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        String folder = "user/";
        switch (type) {
            case 0:
                folder += "avatar/";
                break;
            case 1:
                folder += "backdrop/";
                break;
            default:
                return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        try {
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            String url = OssUtil.upload(folder + userId + "/" + UUID.randomUUID().toString().replace("-", "") + suffix, file.getInputStream());

            UserInfo.Builder builder = new UserInfo.Builder().id(userInfo.getId());
            switch (type) {
                case 0:
                    userInfoMapper.updateById(builder.avatarUrl(url).build());
                    break;
                case 1:
                    userInfoMapper.updateById(builder.backdropUrl(url).build());
                    break;
                default:
                    return JsonResult.failure(ErrorCode.BAD_REQUEST);
            }
            return JsonResult.success(url);
        } catch (IOException e) {
            return JsonResult.failure(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
