package com.jixiao.api.modular.user.service;

import com.jixiao.common.JsonResult;
import com.jixiao.user.entity.vo.UserCommentVO;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserCommentService {

    /**
     * 我要评论 or 回复评论
     *
     * @param userDynamicId 动态Id
     * @param parentId 回复评论Id
     * @param content 舆论
     * @param userId 用户Id
     * @return json
     */
    JsonResult save(Long userDynamicId, Long parentId, String content, Long userId);

    /**
     * 删除评论
     *
     * @param id 主键
     * @param userDynamicId 动态Id
     * @param userId 用户Id
     * @return json
     */
    JsonResult remove(Long id, Long userDynamicId, Long userId);

    /**
     * 查询评论
     *
     * @param userDynamicId 动态Id
     * @return json
     */
    List<UserCommentVO> listByUserDynamicId(Long userDynamicId);

}
