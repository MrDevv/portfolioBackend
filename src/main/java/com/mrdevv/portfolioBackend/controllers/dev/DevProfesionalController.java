package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.config.swagger.OpenApiConfig;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev")
@Tag(name = "Dev - Perfil profesional", description = "Consulta pública de los datos profesionales mediante API key")
@SecurityRequirement(name = OpenApiConfig.API_KEY_AUTH)
public class DevProfesionalController {

    private final IProfesionalService profesionalService;

    @GetMapping("me/datos")
    @Operation(summary = "Obtener datos profesionales", description = "Obtiene los datos profesionales del propietario de la API key.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo los datos profesionales correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED_API_KEY),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_API_KEY)
            }
    )
    public ResponseEntity obtenerDatosProfesionales(){
        ResponseProfesionalDTO profesionalDTO = profesionalService.obtenerDatosProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo los datos profesionales correctamente", profesionalDTO);
    }
}
