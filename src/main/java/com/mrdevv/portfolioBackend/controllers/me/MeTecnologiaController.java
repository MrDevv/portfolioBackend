package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.request.CreateTecnologiaProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateTecnologiaProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("me/tecnologias")
@Tag(name = "Tecnologías - usuario autenticado", description = "Operaciones relacionadas con las tecnologías del usuario autenticado")
public class MeTecnologiaController {

    private final IProfesionalTecnologiaService profesionalTecnologiaService;

    @GetMapping()
    @Operation(summary = "Obtener tecnologías del usuario autenticado", description = "Obtiene la lista de tecnologías asociadas al usuario autenticado. Se puede filtrar por nombre.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las tecnologías del profesional correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El filtro 'nombre' debe tener al menos 2 caracteres."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerTecnologiasProfesionalAutenticado(
            @Parameter(description = "Filtro por nombre de la tecnología (mínimo 2 caracteres).", example = "Java")
            @RequestParam(required = false) @Size(min = 2, message = "Mínimo 2 caracteres") String nombre){
        List<ResponseProfesionalTecnologiaDTO> tecnologias = profesionalTecnologiaService.obtenerTecnologiasProfesionalAutenticado(nombre);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías del profesional correctamente", tecnologias);
    }

    @PostMapping()
    @Operation(summary = "Registrar tecnología", description = "Asocia una tecnología del catálogo al usuario autenticado indicando su nivel de dominio.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se registró correctamente la tecnología para el profesional"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la tecnología con el UUID proporcionado."),
                    @ApiResponse(responseCode = "409", description = "Conflicto. La tecnología ya está registrada para el profesional.")
            }
    )
    public ResponseEntity registrarNuevaTecnologiaProfesionalAutenticado(@Valid @RequestBody CreateTecnologiaProfesionalDTO tecnologiaProfesionalDTO) {
        ResponseProfesionalTecnologiaDTO profesionalTecnologia = profesionalTecnologiaService.registrarTecnologiaProfesionalAutenticado(tecnologiaProfesionalDTO);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se registró correctamente la tecnología para el profesional", profesionalTecnologia);
    }

    @PatchMapping("/{uuid}")
    @Operation(summary = "Actualizar nivel de una tecnología", description = "Actualiza el nivel de dominio de una tecnología asociada al usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizó correctamente la tecnología del profesional"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la tecnología del profesional con el UUID proporcionado.")
            }
    )
    public ResponseEntity actualizarTecnologiaProfesionalAutenticado(
            @Parameter(description = "UUID de la relación profesional-tecnología.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String profesionalTecnologiaUUID, @Valid @RequestBody UpdateTecnologiaProfesionalDTO tecnologiaProfesionalDTO) {
        ResponseProfesionalTecnologiaDTO profesionalTecnologia = profesionalTecnologiaService.actualizarTecnologiaProfesionalAutenticado(profesionalTecnologiaUUID, tecnologiaProfesionalDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "Se actualizó correctamente la tecnología del profesional", profesionalTecnologia);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Eliminar tecnología", description = "Elimina la asociación de una tecnología con el usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se eliminó correctamente la tecnología del profesional"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la tecnología del profesional con el UUID proporcionado.")
            }
    )
    public ResponseEntity eliminarTecnologiaProfesionalAutenticado(
            @Parameter(description = "UUID de la relación profesional-tecnología.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String profesionalTecnologiaUUID) {
        profesionalTecnologiaService.eliminarTecnologiaProfesionalAutenticado(profesionalTecnologiaUUID);
        return ResponseHandler.ok(TipoResponse.DELETE, "Se eliminó correctamente la tecnología del profesional", null);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Obtener tecnología por UUID", description = "Obtiene una tecnología asociada al usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo correctamente la tecnología del profesional"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la tecnología del profesional con el UUID proporcionado.")
            }
    )
    public ResponseEntity obtenerTecnologiaProfesionalAutenticado(
            @Parameter(description = "UUID de la relación profesional-tecnología.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String profesionalTecnologiaUUID) {
        ResponseProfesionalTecnologiaDTO profesionalTecnologia = profesionalTecnologiaService.obtenerTecnologiaProfesionalAutenticado(profesionalTecnologiaUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo correctamente la tecnología del profesional", profesionalTecnologia);
    }
}
