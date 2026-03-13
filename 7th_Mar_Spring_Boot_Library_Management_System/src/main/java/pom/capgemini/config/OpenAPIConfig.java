package pom.capgemini.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Library Management System API",
                version = "1.0",
                description = "REST API for managing a city library system with User Management, Book Management, and Borrow Management features.",
                contact = @Contact(
                        name = "Library Management System",
                        email = "admin@library.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local Development Server"
                )
        },
        security = @SecurityRequirement(name = "basicAuth")
)
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic",
        in = SecuritySchemeIn.HEADER,
        description = "Enter your username and password for Basic Authentication"
)
public class OpenAPIConfig {
}


