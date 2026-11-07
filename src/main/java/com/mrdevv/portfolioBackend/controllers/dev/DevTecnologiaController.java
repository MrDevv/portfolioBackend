package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.config.swagger.OpenApiConfig;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
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

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev/me/tecnologias")
@Tag(name = "Dev - Tecnologías", description = "Consulta pública de las tecnologías del profesional mediante API key")
@SecurityRequirement(name = OpenApiConfig.API_KEY_AUTH)
public class DevTecnologiaController {

    private final IProfesionalTecnologiaService profesionalTecnologiaService;

    @GetMapping()
    @Operation(summary = "Obtener tecnologías", description = "Obtiene la lista de tecnologías del propietario de la API key.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las tecnologías correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED_API_KEY),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_API_KEY)
            }
    )
    public ResponseEntity obtenerTecnologiasProfesional(){
        List<ResponseProfesionalTecnologiaDTO> tecnologias = profesionalTecnologiaService.obtenerTecnologiasProfesionalAutenticado(null);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías correctamente", tecnologias);
    }
}
