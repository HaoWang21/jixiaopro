package com.jixiao.user.entity.dto;

import com.jixiao.user.entity.dto.base.BaseUserDynamicDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文字动态
 * </p>
 *
 * @author jiang
 * @since 2018-10-09
 */
public class UserDynamicContentDTO extends BaseUserDynamicDTO {

    @ApiModelProperty(value = "内容", required = true)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserDynamicContentDTO{" +
                "content='" + content + '\'' +
                '}';
    }
}
