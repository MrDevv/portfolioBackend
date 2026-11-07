package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me/proyectos")
@Tag(name = "Proyectos - usuario autenticado", description = "Operaciones relacionadas con los proyectos del usuario autenticado")
public class MeProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping
    @Operation(summary = "Obtener proyectos del usuario autenticado", description = "Obtiene una lista de proyectos asociados al usuario autenticado. Se puede filtrar por título y paginar los resultados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los proyectos correctamente"),
                    @ApiResponse(responseCode = "401", description = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado.")
            }
    )
    public ResponseEntity obtenerProyectosProfesionalAutenticado(@RequestParam(name = "titulo", required = false) String titulo,
                                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectos = proyectoService.obtenerProyectosProfesionalAutenticado(titulo, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los proyectos correctamente", proyectos);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Obtener proyecto por UUID", description = "Obtiene un proyecto asociado al usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo el proyecto correctamente"),
                    @ApiResponse(responseCode = "401", description = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado."),
                    @ApiResponse(responseCode = "404", description = "No se encontró el proyecto con el UUID proporcionado.")
            }
    )
    public ResponseEntity obtenerProyectoPorUUID(@PathVariable(name = "uuid") String proyectoUUID){
        ResponseProyectoDTO proyecto = proyectoService.obtenerProyectoPorUUID(proyectoUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo el proyecto correctamente", proyecto);
    }

    @PostMapping
    @Operation(summary = "Crear proyecto", description = "Crea un nuevo proyecto asociado al usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Se creó el proyecto correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. Los datos proporcionados no cumplen con las validaciones requeridas."),
                    @ApiResponse(responseCode = "401", description = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado."),
                    @ApiResponse(responseCode = "409", description = "Conflicto. Ya existe un proyecto con los mismos datos proporcionados.")
            }
    )
    public ResponseEntity crearProyecto(@Valid @RequestBody CreateProyectoDTO proyectoDTO){
        ResponseProyectoDTO proyectoCreado = proyectoService.crearProyecto(proyectoDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "Se creó el proyecto correctamente", proyectoCreado);
    }

    @PutMapping("/{uuid}")
    @Operation(summary = "Actualizar proyecto", description = "Actualiza un proyecto asociado al usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizó el proyecto correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. Los datos proporcionados no cumplen con las validaciones requeridas."),
                    @ApiResponse(responseCode = "401", description = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado."),
                    @ApiResponse(responseCode = "404", description = "No se encontró el proyecto con el UUID proporcionado.")
            }
    )
    public ResponseEntity actualizarProyecto(@PathVariable(name = "uuid") String proyectoUUID, @Valid @RequestBody UpdateProyectoDTO proyectoDTO){
        ResponseProyectoDTO proyectoActualizado = proyectoService.actualizarProyecto(proyectoUUID, proyectoDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "Se actualizó el proyecto correctamente", proyectoActualizado);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Eliminar proyecto", description = "Elimina un proyecto asociado al usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se eliminó el proyecto correctamente"),
                    @ApiResponse(responseCode = "401", description = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado."),
                    @ApiResponse(responseCode = "404", description = "No se encontró el proyecto con el UUID proporcionado.")
            }
    )
    public ResponseEntity eliminarProyecto(@PathVariable(name = "uuid") String proyectoUUID){
        proyectoService.eliminarProyecto(proyectoUUID);
        return ResponseHandler.ok(TipoResponse.DELETE, "Se eliminó el proyecto correctamente", null);
    }
}
