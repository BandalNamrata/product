package com.algoDomain.TechnicalTask.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2

public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
    public Docket studentApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.algoDomain.TechnicalTask"))
               // .paths(regex("/user.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Product infi")
                .description("\"Product Information Display\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Namrata", "http://springframework", "abc@gmail.com"))
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/user/**")
                .addResourceLocations("classpath:/META-INF/resources/user/");
    }

}
