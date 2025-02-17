package com.algaworks.algafood.core.springdoc;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
                            ).components(new Components().schemas(
                                    gerarSchemas()
                            ));
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
                            )
                            .tags(Arrays.asList(
                                    new Tag().name("Cidades").description("Gerencia as cidades")
                            )).components(new Components().schemas(
                                    gerarSchemas()
                            ));
                })
                .build();
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            openApi.getPaths()
                    .values()
                    .forEach(pathItem -> pathItem.readOperationsMap()
                            .forEach((httpMethod, operation) -> {
                                ApiResponses responses = operation.getResponses();
                                switch (httpMethod) {
                                    case GET:
                                        responses.addApiResponse("404", new ApiResponse().description("Recurso não encontrado"));
                                        responses.addApiResponse("406", new ApiResponse()
                                                .description("Recurso não possui representação que poderia ser aceita pelo consumidor"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    case POST:
                                        responses.addApiResponse("400", new ApiResponse().description("Requisição inválida"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    case PUT:
                                        responses.addApiResponse("404", new ApiResponse().description("Recurso não encontrado"));
                                        responses.addApiResponse("400", new ApiResponse().description("Requisição inválida"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    case DELETE:
                                        responses.addApiResponse("404", new ApiResponse().description("Recurso não encontrado"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    default:
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                }
                            })
                    );
        };
    }

    private Map<String, Schema> gerarSchemas() {
        final Map<String, Schema> schemaMap = new HashMap<>();

        Map<String, Schema> problemSchema = ModelConverters.getInstance().read(Problem.class);
        Map<String, Schema> problemObjectSchema = ModelConverters.getInstance().read(Problem.Object.class);

        schemaMap.putAll(problemSchema);
        schemaMap.putAll(problemObjectSchema);

        return schemaMap;
    }
}