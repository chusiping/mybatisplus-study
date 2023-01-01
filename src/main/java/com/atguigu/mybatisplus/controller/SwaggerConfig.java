package com.atguigu.mybatisplus.controller;
import io.swagger.annotations.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //开启swagger
public class SwaggerConfig {

    @Bean
    Docket docket(Environment environment) {
        //设置要显示swagger的环境，只有dev、test这两个环境才会显示swagger的api文档
        Profiles profiles = Profiles.of("dev","test");
        boolean isEnable = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors.basePackage("com.ligang.swagger.controller") 指定需要扫描的包（一般使用这种方式）
                //RequestHandlerSelectors.any() 扫描全部
                //RequestHandlerSelectors.none() 不扫描
                //RequestHandlerSelectors.withClassAnnotation()
                //RequestHandlerSelectors.withMethodAnnotation()
                .apis(RequestHandlerSelectors.basePackage("com.atguigu.mybatisplus.controller"))
                //PathSelectors.ant("/swagger/**") 过滤某些路径（/swagger/**这些路径的接口不扫描）
                .build();
    }

    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact(
                "jarry",
                "15home.com",
                "fanbq@gzqiaoyin.com");

        return new ApiInfo(
                "信息化部内部系统Swagger API文档",
                "平凡中蕴藏无限力量",
                "V1.0",
                "15home.com",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
