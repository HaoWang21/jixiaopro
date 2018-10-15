package com.jixiao.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 * 程序入口
 * </p>
 *
 * @author jiang
 * @since 2018-09-19
 */
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

    private final static Logger Log = LoggerFactory.getLogger(ApiApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApiApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        Log.debug("In service !");
    }
}
