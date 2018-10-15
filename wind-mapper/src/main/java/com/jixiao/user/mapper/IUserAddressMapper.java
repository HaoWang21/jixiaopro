package com.jixiao.user.mapper;

import com.jixiao.user.entity.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.user.entity.vo.UserAddressVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @since 2018-10-01
 */
public interface IUserAddressMapper extends BaseMapper<UserAddress> {

    /**
     * 根据用户Id查询地址列表
     *
     * @param userId 用户Id
     * @return vo
     */
    List<UserAddressVO> selectVoListByUserId(Long userId);

    /**
     * 根据id 用户Id查询地址详情
     *
     * @param id 地址Id
     * @param userId 用户Id
     * @return vo
     */
    UserAddressVO selectVOByIdAndUserId(@Param("id") Long id, @Param("userId") Long userId);

}
