package com.jixiao.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * <p>
 * session配置
 * </p>
 *
 * @author jiang
 * @since 2018-10-08
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
