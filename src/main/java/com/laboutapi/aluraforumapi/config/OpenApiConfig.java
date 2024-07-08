package com.laboutapi.aluraforumapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Criando a configuração básica da página de documentação da API
 * utilizando <a href="https://swagger.io/">Swagger</a> implementado
 * pela <a href="https://www.openapis.org/">OpenAPI</a></p>
 *
 * <hr/>
 * Configurando utilização de autenticação (Token JWT) na pagina da documentação
 */
@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Forum Alura API",
        description = "Uma API Rest feita em resposta ao 4º Challenge da turma 6 do programa One \"Forum Alura\".",
        version = "2.0",
        contact = @Contact(name = "Jeferson Labout", email = "jefson1989@gmail.com", url = "https://github.com/jeferson-labout"))
)
@SecurityScheme(
        name = "TokenJWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
}
