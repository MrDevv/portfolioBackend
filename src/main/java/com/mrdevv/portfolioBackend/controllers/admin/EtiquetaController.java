package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IEtiquetaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/etiquetas")
@RequiredArgsConstructor
@Tag(name = "Catálogo - Etiquetas", description = "Consulta de las etiquetas disponibles para los proyectos")
public class EtiquetaController {

    private final IEtiquetaService etiquetaService;

    @GetMapping
    @Operation(summary = "Obtener etiquetas", description = "Obtiene una lista paginada de etiquetas. Se puede filtrar por nombre.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las etiquetas correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerEtiquetas(
            @Parameter(description = ApiDocs.PARAM_PAGE, example = "0")
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @Parameter(description = ApiDocs.PARAM_SIZE, example = "40")
            @RequestParam(name = "size", required = false, defaultValue = "40") Integer size,
            @Parameter(description = "Filtro por nombre de la etiqueta.", example = "spring")
            @RequestParam(name = "nombre", required = false) String nombre) {
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable etiquetas = etiquetaService.obtenerEtiquetas(pageable, nombre);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las etiquetas correctamente", etiquetas);
    }
}
