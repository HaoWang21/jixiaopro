package com.jixiao.user.entity.dto;

import com.jixiao.user.entity.dto.base.BaseUserDynamicDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文字图片动态
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class UserDynamicContentImageDTO extends BaseUserDynamicDTO {

    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "资源Ids", required = true)
    private String uploadIds;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUploadIds() {
        return uploadIds;
    }

    public void setUploadIds(String uploadIds) {
        this.uploadIds = uploadIds;
    }

    @Override
    public String toString() {
        return "UserDynamicContentImageDTO{" +
                "content='" + content + '\'' +
                ", uploadIds='" + uploadIds + '\'' +
                '}';
    }
}
