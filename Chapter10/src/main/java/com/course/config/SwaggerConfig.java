package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")    //配置访问路径
                .select()//选择目录
                .paths(PathSelectors.regex("/.*"))//选择器，匹配访问方法匹配路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的接口文档")//生成文档的title
                .contact(new Contact("lvxiaolin","","1132617736@qq.com")) //联系人信息
                .description("这是我的swaggerui生成的接口文档")  //描述
                .version("1.0.0.0")  //版本
                .build();   //build配置文件
    }


}
