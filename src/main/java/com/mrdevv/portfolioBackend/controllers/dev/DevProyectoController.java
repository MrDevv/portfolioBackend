package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.config.swagger.OpenApiConfig;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev/me/proyectos")
@Tag(name = "Dev - Proyectos", description = "Consulta pública de los proyectos del profesional mediante API key")
@SecurityRequirement(name = OpenApiConfig.API_KEY_AUTH)
public class DevProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping()
    @Operation(summary = "Obtener proyectos", description = "Obtiene una lista paginada de proyectos del propietario de la API key.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los proyectos correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED_API_KEY),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_API_KEY)
            }
    )
    public ResponseEntity obtenerProyectosProfesional(
            @Parameter(description = ApiDocs.PARAM_PAGE, example = "0")
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @Parameter(description = ApiDocs.PARAM_SIZE, example = "4")
            @RequestParam(name = "size", defaultValue = "4", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectosDTO = proyectoService.obtenerProyectosProfesional(pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los proyectos correctamente", proyectosDTO);
    }
}
