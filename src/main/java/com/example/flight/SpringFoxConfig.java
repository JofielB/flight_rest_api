package com.example.flight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/airports/flightAPI/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.flight"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Flight API",
                "Simple API to get the airports base on a search param",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Jofiel Batista", "", "jofielbatista@hotmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}