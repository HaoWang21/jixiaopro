package com.jixiao.user.entity.dto;

import com.jixiao.user.entity.dto.base.BaseUserDynamicDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文字视频动态
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class UserDynamicContentVideoDTO extends BaseUserDynamicDTO {

    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "资源Ids", required = true)
    private Long uploadId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    @Override
    public String toString() {
        return "UserDynamicContentVideoDTO{" +
                "content='" + content + '\'' +
                ", uploadId=" + uploadId +
                '}';
    }
}
