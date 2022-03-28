package com.togoinov.user.web;

import com.togoinov.user.UserServiceApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.NonNull;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "User Service API",
                description = "Gestion des utilisateurs",
                contact = @Contact(
                        email = "adanlessossi@hotmail.com",
                        name = "togoinov"
                )
        )
)

@Configuration
public class OpenApiConfig {

    @NonNull
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("User Service API")
                .pathsToMatch("/api/**")
                .packagesToScan(UserServiceApplication.class.getPackageName())
                .build();
    }
}
