package com.jixiao.api.modular.user.service.impl;

import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.UserAddress;
import com.jixiao.user.entity.dto.UserAddressUpdateDTO;
import com.jixiao.user.entity.vo.UserAddressVO;
import com.jixiao.user.mapper.IUserAddressMapper;
import com.jixiao.api.modular.user.service.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 * @since 2018-10-01
 */
@Service
public class UserAddressServiceImpl implements IUserAddressService {

    @Autowired
    private IUserAddressMapper userAddressMapper;

    @Override
    public JsonResult<List<UserAddressVO>> list(Long userId) {
        return JsonResult.success(userAddressMapper.selectVoListByUserId(userId));
    }

    @Override
    public JsonResult save(UserAddressUpdateDTO dto, Long userId) {
        userAddressMapper.insert(new UserAddress.Builder()
                .userId(userId)
                .nickName(dto.getNickName())
                .mobile(dto.getMobile())
                .provinceToolDistrictId(dto.getProvinceId())
                .cityToolDistrictId(dto.getCityId())
                .areaToolDistrictId(dto.getAreaId())
                .address(dto.getAddress())
                .defaultAddress(dto.getDefaultAddress())
                .build());
        return JsonResult.success();
    }

    @Override
    public JsonResult remove(Long id, Long userId) {
        UserAddress userAddress = userAddressMapper.selectById(id);
        if (null == userAddress || !userAddress.getUserId().equals(userId)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        userAddressMapper.updateById(new UserAddress.Builder().id(userAddress.getId()).delFlag(true).build());
        return JsonResult.success();
    }

    @Override
    public JsonResult update(Long id, UserAddressUpdateDTO dto, Long userId) {
        UserAddress userAddress = userAddressMapper.selectById(id);
        if (null == userAddress || userAddress.getDelFlag() || !userAddress.getUserId().equals(userId)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        userAddressMapper.updateById(new UserAddress.Builder()
                .id(id)
                .nickName(dto.getNickName())
                .mobile(dto.getMobile())
                .provinceToolDistrictId(dto.getProvinceId())
                .cityToolDistrictId(dto.getCityId())
                .areaToolDistrictId(dto.getAreaId())
                .address(dto.getAddress())
                .defaultAddress(dto.getDefaultAddress())
                .build());
        return JsonResult.success();
    }

    @Override
    public JsonResult details(Long id, Long userId) {
        UserAddressVO vo = userAddressMapper.selectVOByIdAndUserId(id, userId);
        if (null == vo) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        return JsonResult.success(vo);
    }
}
