package com.algaworks.algafood.core.springdoc;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "security_auth",
        type = SecuritySchemeType.OAUTH2,
        flows =  @OAuthFlows(authorizationCode = @OAuthFlow(
                authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
                tokenUrl = "${springdoc.oAuthFlow.tokenUrl}",
                scopes = {
                        @OAuthScope(name = "READ", description = "read scope"),
                        @OAuthScope(name = "WRITE", description = "write scope"),
                }
        )))
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi v1Api() {
        return GroupedOpenApi.builder()
                .group("Version 1.0")
                .pathsToMatch("/v1/**")
                .addOpenApiCustomiser(openApi -> {
                    openApi.info(new Info().title("Algafood API")
                                    .version("v1")
                                    .description("Rest API do Algafood")
                                    .license(new License()
                                            .name("Apache 2.0")
                                            .url("http://springdoc.com"))
                            )
                            .externalDocs(new ExternalDocumentation()
                                    .description("AlgaWorks")
                                    .url("https://algaworks.com")
                            );
                })
                .build();
    }

    @Bean
    public GroupedOpenApi v2Api() {
        return GroupedOpenApi.builder()
                .group("Version 2.0")
                .pathsToMatch("/v2/**")
                .addOpenApiCustomiser(openApi -> {
                    openApi.info(new Info().title("Algafood API")
                                    .version("v2")
                                    .description("Rest API do Algafood")
                                    .license(new License()
                                            .name("Apache 2.0")
                                            .url("http://springdoc.com"))
                            )
                            .externalDocs(new ExternalDocumentation()
                                    .description("AlgaWorks")
                                    .url("https://algaworks.com")
                            );
                })
                .build();
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser(){
        return openApi -> {
            openApi.getPaths() // itera entre os paths da nossa aplicacao
                    .values()
                    .stream()
                    .flatMap(pathItem -> pathItem.readOperations().stream())
                    .forEach(operation -> {
                        ApiResponses responses = operation.getResponses();

                        ApiResponse apiResponseNaoEncontrado = new ApiResponse().description("Recurso não encontrado");
                        ApiResponse apiResponseErroInterno = new ApiResponse().description("Erro interno no servidor");
                        ApiResponse apiResponseSemRepresentacao = new ApiResponse().description("Recurso não possui uma representação aceita pelo consumidor");

                        responses.addApiResponse("406", apiResponseNaoEncontrado);
                        responses.addApiResponse("406", apiResponseSemRepresentacao);
                        responses.addApiResponse("500", apiResponseErroInterno);
                    });
        };
    }
}
