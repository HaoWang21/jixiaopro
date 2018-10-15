package com.jixiao.api.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 自定义元素
 * </p>
 *
 * @author jiang
 * @since 2017-12-13
 */
@Component
@ConfigurationProperties(
        prefix = "org.defined"
)
public class DiyProperties {

    /**
     * 是否激活文档开
     */
    private boolean swagger2Enabled;
    /**
     * 是否激活短信
     */
    private boolean shortMessageEnabled;
    /**
     * 小程序
     */
    private String appId;
    private String secret;
    /**
     * 短信
     */
    private String messageAccessKeyId;
    private String messageAccessKeySecret;
    /**
     * OSS
     */
    private String ossAccessKeyId;
    private String ossAccessKeySecret;
    private String endpoint;
    private String bucket;
    private String uri;

    public boolean getSwagger2Enabled() {
        return swagger2Enabled;
    }

    public void setSwagger2Enabled(boolean swagger2Enabled) {
        this.swagger2Enabled = swagger2Enabled;
    }

    public boolean getShortMessageEnabled() {
        return shortMessageEnabled;
    }

    public void setShortMessageEnabled(boolean shortMessageEnabled) {
        this.shortMessageEnabled = shortMessageEnabled;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMessageAccessKeyId() {
        return messageAccessKeyId;
    }

    public void setMessageAccessKeyId(String messageAccessKeyId) {
        this.messageAccessKeyId = messageAccessKeyId;
    }

    public String getMessageAccessKeySecret() {
        return messageAccessKeySecret;
    }

    public void setMessageAccessKeySecret(String messageAccessKeySecret) {
        this.messageAccessKeySecret = messageAccessKeySecret;
    }

    public String getOssAccessKeyId() {
        return ossAccessKeyId;
    }

    public void setOssAccessKeyId(String ossAccessKeyId) {
        this.ossAccessKeyId = ossAccessKeyId;
    }

    public String getOssAccessKeySecret() {
        return ossAccessKeySecret;
    }

    public void setOssAccessKeySecret(String ossAccessKeySecret) {
        this.ossAccessKeySecret = ossAccessKeySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
