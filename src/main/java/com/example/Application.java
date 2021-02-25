package com.example;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("1.0.0") String appVersion) {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("OAuth2", new SecurityScheme().type(SecurityScheme.Type.OAUTH2).scheme("OAuth2"))
                        .addParameters("X-Auth-Token", new Parameter().in("header").schema(new StringSchema()).name("X-Auth-Token")).addHeaders("myHeader2", new Header().description("Base64 Auth Token").schema(new StringSchema())))
                .info(new Info()
                        .title("User Service API")
                        .version(appVersion)
                        .description("User Service API")
                        .termsOfService("http://example.com/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
