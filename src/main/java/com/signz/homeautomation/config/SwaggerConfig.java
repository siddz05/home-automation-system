package com.signz.homeautomation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public static final String HOME_AUTOMATION_APP_NAME = "Home Automation APIs";

    public static final String HOME_AUTOMATION_APP_DESCRIPTION = "Home Automation APIs";

    public static final String HOME_AUTOMATION_APP_DISPLAY_VERSION = "v1.0";

    public static final String HOME_AUTOMATION_APP_BASE_PACKAGE = "com.signz.homeautomation.controller";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(HOME_AUTOMATION_APP_BASE_PACKAGE))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }


    private ApiInfo metaData() {
        return new ApiInfoBuilder().title(HOME_AUTOMATION_APP_NAME).description(HOME_AUTOMATION_APP_DESCRIPTION)
                .version(HOME_AUTOMATION_APP_DISPLAY_VERSION).build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
