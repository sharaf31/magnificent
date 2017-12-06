package com.hhr.recruitment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.ModelMapper;

import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by sharaf on 12/5/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket offerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hhr.recruitment.controller"))
                .paths(regex(".*"))
                .build().apiInfo(metaData());
    }



    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "heavenHR REST API",
                "heavenHR REST API for Recruitment",
                "1.0",
                "Terms of service",
                "Sharaf Navas",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }




}
