package com.jixiao.user.mapper;

import com.jixiao.user.entity.UserFollow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.user.entity.UserUpload;
import com.jixiao.user.entity.vo.UserFollowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserFollowMapper extends BaseMapper<UserFollow> {

    /**
     * 查询我的关注
     * @param userId 用户Id
     * @param ids 我关注的人Ids
     * @return list
     */
    List<UserFollow> selectListByUserIdAndIds(@Param("userId") Long userId, @Param("ids") String ids);

    /**
     * 我关注的人
     *
     * @param userId 用户Id
     * @return list
     */
    List<UserFollowVO> selectListByUserId(Long userId);

}
