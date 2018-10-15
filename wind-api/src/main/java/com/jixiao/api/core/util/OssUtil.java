package com.jixiao.api.core.util;

import com.aliyun.oss.OSSClient;
import com.jixiao.api.core.DiyProperties;
import com.jixiao.api.core.util.scan.SpringContextUtil;

import java.io.InputStream;

/**
 * <p>
 * 对象储存OSS工具
 * 文档：https://help.aliyun.com/product/31815.html?spm=a2c4g.11174283.6.539.46267da2tknTjE
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class OssUtil {

    private static String bucket;
    private static String uri;

    private static OSSClient getOSSClient() {
        DiyProperties bean = SpringContextUtil.getBean(DiyProperties.class);
        bucket = bean.getBucket();
        uri = bean.getUri();
        return new OSSClient(bean.getEndpoint(), bean.getOssAccessKeyId(), bean.getOssAccessKeySecret());
    }

    /**
     * 上传
     * @param key 主键
     * @param input 文件流
     * @return url
     */
    public static String upload(String key, InputStream input) {
        getOSSClient().putObject(bucket, key, input);
        return uri + key;
    }

    /**
     * 刪除
     * @param key 主键
     */
    public static void delete(String key) {
        getOSSClient().deleteObject(bucket, key);
    }
}
