package com.jixiao.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 程序入口
 * </p>
 *
 * @author jiang
 * @since 2018-09-19
 */
@EnableTransactionManagement
@SpringBootApplication
public class SystemApplication {

    private final static Logger Log = LoggerFactory.getLogger(SystemApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        Log.debug("In service !");
    }
}
