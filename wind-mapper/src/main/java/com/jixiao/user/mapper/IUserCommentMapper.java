package com.jixiao.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jixiao.user.entity.UserComment;
import com.jixiao.user.entity.vo.UserCommentVO;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
public interface IUserCommentMapper extends BaseMapper<UserComment> {


    /**
     * 评论一级菜单
     *
     * @param userDynamicId 动态Id
     * @return list
     */
    List<UserCommentVO> selectVoListByUserDynamicId(Long userDynamicId);

    /**
     * 评论的回复
     *
     * @param userCommentId 评论Id
     * @return list
     */
    List<UserCommentVO> selectVoListByUserCommentId(Long userCommentId);

}
