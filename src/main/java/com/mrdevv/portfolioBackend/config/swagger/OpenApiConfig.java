package com.mrdevv.portfolioBackend.config.swagger;

import com.mrdevv.portfolioBackend.handler.ResponseError;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class OpenApiConfig {

    public static final String BEARER_AUTH = "bearerAuth";
    public static final String API_KEY_AUTH = "apiKeyAuth";

    private static final String BEARER_FORMAT = "JWT";
    private static final String DESCRIPTION = "Autenticación mediante token JWT. Debe incluirse en el encabezado de la solicitud como 'Authorization: Bearer <token>'.";
    private static final String API_KEY_DESCRIPTION = "Autenticación mediante API key del profesional, utilizada en los endpoints públicos 'dev/**'. Debe incluirse en el encabezado de la solicitud como 'Authorization: Bearer <api_key>'. Se genera en POST /me/api-key.";

    @Bean
    public OpenAPI customOpenAPI() {
        ResolvedSchema errorSchema = ModelConverters.getInstance()
                .resolveAsResolvedSchema(new AnnotatedType(ResponseError.class));

        Components components = new Components()
                .addSecuritySchemes(BEARER_AUTH,
                        new SecurityScheme()
                                .name(BEARER_AUTH)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat(BEARER_FORMAT)
                                .in(SecurityScheme.In.HEADER)
                                .description(DESCRIPTION))
                .addSecuritySchemes(API_KEY_AUTH,
                        new SecurityScheme()
                                .name(API_KEY_AUTH)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("API Key")
                                .in(SecurityScheme.In.HEADER)
                                .description(API_KEY_DESCRIPTION));

        components.addSchemas("ResponseError", errorSchema.schema);

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(BEARER_AUTH))
                .components(components)
                .info(new Info()
                        .title("DevVault API")
                        .version("1.0")
                        .description("API Restful para la gestión de datos profesionales, experiencias, proyectos, tecnologías.")
                        .contact(new Contact()
                                .name("MrDevv")
                                .email("miguelvegap10@gmail.com")
                                .url("https://mrdevv.netlify.app"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }

    /**
     * Asocia el esquema {@link ResponseError} a las respuestas de error (4xx y 5xx) documentadas
     * que no declaren un contenido propio.
     */
    @Bean
    public OperationCustomizer errorResponseCustomizer() {
        return (operation, handlerMethod) -> {
            if (operation.getResponses() == null) {
                return operation;
            }
            operation.getResponses().forEach((code, response) -> {
                boolean esError = code.startsWith("4") || code.startsWith("5");
                if (esError && response.getContent() == null) {
                    Schema<?> ref = new Schema<>().$ref("#/components/schemas/ResponseError");
                    response.setContent(new Content()
                            .addMediaType(MediaType.APPLICATION_JSON_VALUE, new io.swagger.v3.oas.models.media.MediaType().schema(ref)));
                }
            });
            return operation;
        };
    }
}
