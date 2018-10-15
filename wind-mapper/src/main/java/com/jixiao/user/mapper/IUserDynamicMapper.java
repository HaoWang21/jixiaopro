package com.jixiao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jixiao.user.entity.UserDynamic;
import com.jixiao.user.entity.vo.UserDynamicDetailsVO;
import com.jixiao.user.entity.vo.UserDynamicFollowVO;
import com.jixiao.user.entity.vo.UserDynamicHotVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserDynamicMapper extends BaseMapper<UserDynamic> {

    /**
     * 查询首页热门
     *
     * @param iPage 分页
     * @param typeId 类目Id
     * @param userId 用户Id
     * @return list
     */
    IPage<UserDynamicHotVO> selectVoListIsHotByUserId(IPage<UserDynamicHotVO> iPage, @Param("typeId") Long typeId,
                                                      @Param("userId") Long userId);

    /**
     * 动态详情
     *
     * @param id 主键
     * @param userId 用户Id
     * @return obj
     */
    UserDynamicDetailsVO selectVoDetailsById(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 改变动态的总点赞收藏数量
     *
     * @param id 主键
     * @param type 类型：0点赞 1收藏
     * @param count 数量
     * @return int
     */
    int updateByIdAndTypeChangeCount(@Param("id") Long id, @Param("type") Integer type, @Param("count") Integer count);

    /**
     * 查询首页关注
     *
     * @param iPage 分页
     * @param followUserId 关注人Id
     * @param userId 用户Id
     * @return list
     */
    IPage<UserDynamicFollowVO> selectVoListIsFollowByUserId(IPage<UserDynamicHotVO> iPage,
                                                            @Param("followUserId") Long followUserId, @Param("userId") Long userId);

    /**
     * 附近
     *
     * @param current 页码
     * @param size 条数
     * @param lng 经度
     * @param lat 纬度
     * @param userId 用户Id
     * @param distance 距离（米）
     * @return json
     */
    List<UserDynamicHotVO> selectVoListIsNearbyByUserId(@Param("current") Long current, @Param("size") Long size,
                                                        @Param("lng") BigDecimal lng, @Param("lat") BigDecimal lat,
                                                        @Param("distance") Integer distance, @Param("userId") Long userId);

}
