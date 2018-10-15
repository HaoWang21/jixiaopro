package com.jixiao.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 网络工具
 * </p>
 *
 * @author jiangdada
 * @since 2018-09-05
 */
public class NetUtil {

    /**
     * get
     * @param url 链接
     * @param paramsMap 参数
     * @return str
     */
    public static String get(String url, Map<String, Object> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(20000)
                .setConnectionRequestTimeout(20000)
                .setSocketTimeout(20000)
                .build();
        try {
            HttpGet method = new HttpGet(getUrl(url, paramsMap));
            method.setConfig(requestConfig);
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * post
     * @param url 链接
     * @param paramsMap 参数
     * @return str
     */
    public static String post(String url, Map<String, Object> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(20000)
                .setConnectionRequestTimeout(20000)
                .setSocketTimeout(20000)
                .build();

        try {
            HttpPost method = new HttpPost(url);
            method.setConfig(requestConfig);
            method.setEntity(new UrlEncodedFormEntity(getParamList(paramsMap), "UTF-8"));
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * post
     * @param url 链接
     * @param paramsMap 参数
     * @param headersMap 参数
     * @return str
     */
    public static String post(String url, Map<String, Object> paramsMap, Map<String, String> headersMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(20000)
                .setConnectionRequestTimeout(20000)
                .setSocketTimeout(20000)
                .build();

        try {
            HttpPost method = new HttpPost(url);
            method.setConfig(requestConfig);
            Set<Map.Entry<String, String>> headers = headersMap.entrySet();
            for (Map.Entry<String, String> entry : headers) {
                method.setHeader(entry.getKey(), entry.getValue());
            }
            method.setEntity(new UrlEncodedFormEntity(getParamList(paramsMap), "UTF-8"));
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    private static String getUrl(String url, Map<String, Object> params) {
        if (null != params) {
            url = url + "?";
            boolean isFirst = true;
            StringBuilder urlBuilder = new StringBuilder(url);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (!isFirst) {
                    urlBuilder.append("&");
                }
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue());
                isFirst = false;
            }
            url = urlBuilder.toString();
        }
        return url;
    }

    private static List<NameValuePair> getParamList(Map<String, Object> paramsMap) {
        List<NameValuePair> paramList = new ArrayList<>();
        for (Map.Entry<String, Object> param : paramsMap.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue()));
            paramList.add(pair);
        }
        return paramList;
    }
}