package com.jixiao.api.modular.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jixiao.api.modular.user.service.IUserCommentService;
import com.jixiao.common.ErrorCode;
import com.jixiao.common.JsonResult;
import com.jixiao.common.util.DateUtil;
import com.jixiao.common.util.StringUtil;
import com.jixiao.user.entity.UserComment;
import com.jixiao.user.entity.UserDynamic;
import com.jixiao.user.entity.vo.UserCommentVO;
import com.jixiao.user.mapper.IUserCommentMapper;
import com.jixiao.user.mapper.IUserDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 * @since 2018-09-28
 */
@Service
public class UserCommentServiceImpl implements IUserCommentService {

    @Autowired
    private IUserCommentMapper userCommentMapper;
    @Autowired
    private IUserDynamicMapper userDynamicMapper;

    @Override
    public JsonResult save(Long userDynamicId, Long parentId, String content, Long userId) {
        if (StringUtil.isBlank(content)) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserDynamic userDynamic = userDynamicMapper.selectOne(new LambdaQueryWrapper<UserDynamic>()
                .eq(UserDynamic::getId, userDynamicId).eq(UserDynamic::getStatus, 0)
                .eq(UserDynamic::getDelFlag, 0));
        if (null == userDynamic) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }

        UserComment.Builder builder = new UserComment.Builder().userDynamicId(userDynamicId).userId(userId)
                .content(StringUtil.encodeBase64String(content));
        if (null != parentId) {
            UserComment userComment = userCommentMapper.selectOne(new LambdaQueryWrapper<UserComment>()
                    .eq(UserComment::getUserDynamicId, userDynamicId).eq(UserComment::getId, parentId)
                    .eq(UserComment::getDelFlag, 0));
            if (null != userComment) {
                if (userId.equals(userComment.getUserId())) {
                    return JsonResult.failure(ErrorCode.BAD_REQUEST);
                }
                if (null == userComment.getParentId()) {
                    builder.parentId(parentId);
                } else {
                    builder.parentId(userComment.getParentId());
                }
                builder.replyUserCommentId(userComment.getId()).replyUserId(userComment.getUserId());
            }
        }

        userCommentMapper.insert(builder.build());
        userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 2, 1);
        return JsonResult.success();
    }

    @Override
    public JsonResult remove(Long id, Long userDynamicId, Long userId) {
        UserComment userComment = userCommentMapper.selectOne(new LambdaQueryWrapper<UserComment>()
                .eq(UserComment::getUserDynamicId, userDynamicId).eq(UserComment::getId, id)
                .eq(UserComment::getUserId, userId).eq(UserComment::getDelFlag, 0));
        if (null == userComment) {
            return JsonResult.failure(ErrorCode.BAD_REQUEST);
        }
        userCommentMapper.updateById(new UserComment.Builder().id(id).delFlag(true).build());
        userDynamicMapper.updateByIdAndTypeChangeCount(userDynamicId, 2, -1);
        return JsonResult.success();
    }

    @Override
    public List<UserCommentVO> listByUserDynamicId(Long userDynamicId) {
        List<UserCommentVO> list = userCommentMapper.selectVoListByUserDynamicId(userDynamicId);
        for (UserCommentVO commentVO : list) {
            commentVO.setNickName(StringUtil.decodeBase64(commentVO.getNickName()));
            commentVO.setContent(StringUtil.decodeBase64(commentVO.getContent()));
            commentVO.setReplyNickName(StringUtil.decodeBase64(commentVO.getReplyNickName()));
            commentVO.setGmtCreate(DateUtil.formatDate(commentVO.getGmtCreate()));
            List<UserCommentVO> voList = userCommentMapper.selectVoListByUserCommentId(commentVO.getId());
            for (UserCommentVO cv : voList) {
                cv.setNickName(StringUtil.decodeBase64(cv.getNickName()));
                cv.setContent(StringUtil.decodeBase64(cv.getContent()));
                cv.setReplyNickName(StringUtil.decodeBase64(cv.getReplyNickName()));
            }
            commentVO.setCommentVOList(voList);
        }
        return list;
    }
}
