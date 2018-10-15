package com.jixiao.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 评论vo
 * </p>
 *
 * @author jiang
 * @since 2018-09-28
 */
public class UserCommentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "头像")
    private String avatarUrl;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "回复人的昵称")
    private String replyNickName;
    @ApiModelProperty(value = "评论时间")
    private String gmtCreate;
    @ApiModelProperty(value = "评论的回复")
    private List<UserCommentVO> commentVOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyNickName() {
        return replyNickName;
    }

    public void setReplyNickName(String replyNickName) {
        this.replyNickName = replyNickName;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<UserCommentVO> getCommentVOList() {
        return commentVOList;
    }

    public void setCommentVOList(List<UserCommentVO> commentVOList) {
        this.commentVOList = commentVOList;
    }

    @Override
    public String toString() {
        return "UserCommentVO{" +
                "id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", replyNickName='" + replyNickName + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", commentVOList=" + commentVOList +
                '}';
    }
}
