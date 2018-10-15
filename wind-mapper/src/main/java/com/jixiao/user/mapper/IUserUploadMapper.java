package com.jixiao.user.mapper;

import com.jixiao.user.entity.UserUpload;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserUploadMapper extends BaseMapper<UserUpload> {

    /**
     * 查询当前资源
     *
     * @param userId 用户Id
     * @param ids 资源Id
     * @return list
     */
    List<UserUpload> selectListByUserIdAndIds(@Param("userId") Long userId, @Param("ids") String[] ids);

    /**
     * 查询资源列表
     *
     * @param userDynamicId 动态Id
     * @return list
     */
    List<String> selectStringListByUserDynamicId(Long userDynamicId);

}
