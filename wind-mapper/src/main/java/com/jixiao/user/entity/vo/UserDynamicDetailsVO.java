package com.jixiao.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 动态详情
 * </p>
 *
 * @author jiang
 * @since 2018-10-10
 */
public class UserDynamicDetailsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "用户Id")
    private Long userId;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "类型")
    private Integer type;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "头像")
    private String avatarUrl;
    @ApiModelProperty(value = "链接")
    private List<String> urlList;
    @ApiModelProperty(value = "是否关注")
    private Boolean follow;
    @ApiModelProperty(value = "是否点赞")
    private Boolean praise;
    @ApiModelProperty(value = "是否收藏")
    private Boolean collect;
    @ApiModelProperty(value = "转发数量")
    private Integer transmitCount;
    @ApiModelProperty(value = "评论数量")
    private Integer commentCount;
    @ApiModelProperty(value = "点赞数量")
    private Integer praiseCount;
    @ApiModelProperty(value = "收藏数量")
    private Integer collectCount;
    @ApiModelProperty(value = "评论")
    private List<UserCommentVO> commentVOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public Boolean getFollow() {
        return follow;
    }

    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    public Boolean getPraise() {
        return praise;
    }

    public void setPraise(Boolean praise) {
        this.praise = praise;
    }

    public Boolean getCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    public Integer getTransmitCount() {
        return transmitCount;
    }

    public void setTransmitCount(Integer transmitCount) {
        this.transmitCount = transmitCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public List<UserCommentVO> getCommentVOList() {
        return commentVOList;
    }

    public void setCommentVOList(List<UserCommentVO> commentVOList) {
        this.commentVOList = commentVOList;
    }

    @Override
    public String toString() {
        return "UserDynamicDetailsVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", urlList=" + urlList +
                ", follow=" + follow +
                ", praise=" + praise +
                ", collect=" + collect +
                ", transmitCount=" + transmitCount +
                ", commentCount=" + commentCount +
                ", praiseCount=" + praiseCount +
                ", collectCount=" + collectCount +
                ", commentVOList=" + commentVOList +
                '}';
    }
}
