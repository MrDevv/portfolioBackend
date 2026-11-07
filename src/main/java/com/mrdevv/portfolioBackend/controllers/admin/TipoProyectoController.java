package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.ITipoProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/tipos-proyectos")
@Tag(name = "Catálogo - Tipos de proyecto", description = "Consulta del catálogo de tipos de proyecto")
public class TipoProyectoController {

    private final ITipoProyectoService proyectoService;

    @GetMapping
    @Operation(summary = "Obtener tipos de proyecto", description = "Obtiene la lista completa de tipos de proyecto.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los tipos de proyectos correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerTiposProyectos(){
        List<ResponseTipoProyectoDTO> tipoProyectos = proyectoService.obtenerTiposProyectos();
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los tipos de proyectos correctamente", tipoProyectos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de proyecto por identificador", description = "Obtiene un tipo de proyecto por su identificador numérico.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo el tipo de proyecto correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El identificador debe ser numérico."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró el tipo de proyecto con el identificador proporcionado.")
            }
    )
    public ResponseEntity obtenerTiposProyecto(
            @Parameter(description = "Identificador numérico del tipo de proyecto.", example = "1")
            @PathVariable(name = "id") Long tipoProyectoId){
        ResponseTipoProyectoDTO tipoProyecto = proyectoService.obtenerTipoProyectoPorId(tipoProyectoId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo el tipo de proyecto correctamente", tipoProyecto);
    }

}
