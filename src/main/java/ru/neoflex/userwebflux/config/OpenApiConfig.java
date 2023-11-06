package ru.neoflex.userwebflux.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "User webflux Api",
                description = "User webflux Api", version = "1.0.0",
                contact = @Contact(
                        name = "Kulieva Veronika"
                )
        )
)
public class OpenApiConfig {
}
