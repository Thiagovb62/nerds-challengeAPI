package com.example.nerds_api.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Controle de Equipamentos nerds",
                version = "v1",
                description = "API para controle de equipamentos"
        )
)
public class OpenApiConfig {
}