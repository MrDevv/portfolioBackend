package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.ITecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("admin/tecnologias")
@Tag(name = "Catálogo - Tecnologías", description = "Consulta del catálogo de tecnologías disponibles")
public class TecnologiaController {

    private final ITecnologiaService tecnologiaService;

    @GetMapping
    @Operation(summary = "Obtener tecnologías", description = "Obtiene una lista paginada del catálogo de tecnologías. Se puede filtrar por nombre.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las tecnologias correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El filtro 'nombre' debe tener al menos 2 caracteres."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerTecnologias(
            @Parameter(description = "Filtro por nombre de la tecnología (mínimo 2 caracteres).", example = "Java")
            @RequestParam(required = false) @Size(min = 2, message = "Mínimo 2 caracteres") String nombre,
            @Parameter(description = ApiDocs.PARAM_PAGE, example = "0")
            @RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
            @Parameter(description = ApiDocs.PARAM_SIZE, example = "8")
            @RequestParam(required = false, name = "size", defaultValue = "8") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable tecnologiaList = tecnologiaService.obtenerTecnologias(nombre, pageable);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvieron las tecnologias correctamente", tecnologiaList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tecnología por identificador", description = "Obtiene una tecnología del catálogo por su identificador numérico.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo la tecnología correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El identificador debe ser numérico."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la tecnología con el identificador proporcionado.")
            }
    )
    public ResponseEntity obtenerTecnologiaPorId(
            @Parameter(description = "Identificador numérico de la tecnología.", example = "1")
            @PathVariable(name = "id") Long tecnologiaId){
        ResponseTecnologiaDTO tecnologia = tecnologiaService.obtenerTecnologiaPorUUID(tecnologiaId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo la tecnología correctamente", tecnologia);
    }

}
