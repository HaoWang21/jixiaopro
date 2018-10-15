package com.jixiao.api.config;

import com.jixiao.api.core.DiyProperties;
import com.jixiao.api.core.util.scan.SpringContextUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * swagger2配置
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 获取文档的的开启状态
     */
    private boolean enable() {
        DiyProperties bean = SpringContextUtil.getBean(DiyProperties.class);
        return bean.getSwagger2Enabled();
    }

    @Bean
    public Docket createLabelRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("1.首页相关")
                .apiInfo(this.apiInfo())
                .enable(this.enable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jixiao.api.modular.label.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createUserRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("2.用户相关")
                .apiInfo(this.apiInfo())
                .enable(this.enable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jixiao.api.modular.user.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createStoreRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("3.门店相关")
                .apiInfo(this.apiInfo())
                .enable(this.enable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jixiao.api.modular.store.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createMallRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("4.商城相关")
                .apiInfo(this.apiInfo())
                .enable(this.enable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jixiao.api.modular.goods.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createToolRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("5.工具")
                .apiInfo(this.apiInfo())
                .enable(this.enable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jixiao.api.modular.tool.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful APIs")
                .description("Talk is cheap,show me the code!")
                .termsOfServiceUrl("http://localhost:8085/swagger-ui.html")
                .contact(new Contact("雾支楼", null, null))
                .version("1.0")
                .build();
    }
}
