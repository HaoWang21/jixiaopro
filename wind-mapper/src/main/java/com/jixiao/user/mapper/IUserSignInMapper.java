package com.jixiao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.user.entity.UserSignIn;
import com.jixiao.user.entity.vo.UserSignInListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserSignInMapper extends BaseMapper<UserSignIn> {

    /**
     * 根据用户Id和日期查询签到记录
     *
     * @param userId 用户Id
     * @param year 年
     * @param month 月
     * @param day 日
     * @return userSignIn
     */
    UserSignIn selectOneByUserIdAndDate(@Param("userId") Long userId, @Param("year") Integer year,
                                        @Param("month") Integer month, @Param("day") Integer day);

    /**
     * 查询签到记录
     *
     * @param userId 用户Id
     * @return vo
     */
    List<UserSignInListVO> selectVoListByUserId(Long userId);
}
