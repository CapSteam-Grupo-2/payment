package com.capgeticket.payment.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    /**
     * Configuracion para realizar la documentacion del Swagger
     */
    @Bean
    public OpenAPI PaymentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Student API")
                        .description("Documentación de la Student API")
                        .version("v1.0")
                        .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Descripcion del proyecto")
                        .url("https://CapgeTicketPayment.es"));
    }
}
