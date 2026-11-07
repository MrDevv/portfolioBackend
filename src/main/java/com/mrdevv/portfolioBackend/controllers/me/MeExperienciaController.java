package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaConProyectosDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaSimpleDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("me/experiencias")
@Tag(name = "Experiencias - usuario autenticado", description = "Operaciones relacionadas con las experiencias profesionales del usuario autenticado")
public class MeExperienciaController {

    private final IExperienciaService experienciaService;

    @GetMapping
    @Operation(summary = "Obtener experiencias del usuario autenticado", description = "Obtiene una lista paginada de experiencias del usuario autenticado. Se puede filtrar por nombre de empresa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las experiencias correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerExperienciasProfesionalAutenticado(
            @Parameter(description = ApiDocs.PARAM_PAGE, example = "0")
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @Parameter(description = ApiDocs.PARAM_SIZE, example = "4")
            @RequestParam(name = "size", defaultValue = "4", required = false) Integer size,
            @Parameter(description = "Filtro por nombre de la empresa.", example = "Acme S.A.")
            @RequestParam(name = "nombre_empresa", required = false) String nombreEmpresa){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable experiencias = experienciaService.obtenerExperienciasProfesionalAutenticado(nombreEmpresa, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron las experiencias correctamente", experiencias);
    }

    @GetMapping("/simple")
    @Operation(summary = "Obtener experiencias en formato simple", description = "Obtiene la lista completa de experiencias del usuario autenticado, solo con su UUID y título. Útil para selectores.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron las experiencias correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity obtenerExperienciasSimpleProfesionalAutenticado(){
        List<ResponseExperienciaSimpleDTO> experiencias = experienciaService.obtenerExperienciasSimpleProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron las experiencias correctamente", experiencias);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Obtener experiencia por UUID", description = "Obtiene una experiencia del usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo correctamente la experiencia profesional"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la experiencia con el UUID proporcionado.")
            }
    )
    public ResponseEntity obtenerExperienciaProfesionalAutenticada(
            @Parameter(description = "UUID de la experiencia.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String experienciaUUID) {
        ResponseExperienciaDTO experiencia = experienciaService.obtenerExperienciaProfesionalAutenticado(experienciaUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo correctamente la experiencia profesional", experiencia);
    }

    @PostMapping
    @Operation(summary = "Registrar experiencia", description = "Registra una nueva experiencia profesional para el usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Se registró correctamente la experiencia profesional"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity registrarExperienciaProfesionalAutenticado(@Valid @RequestBody CreateExperienciaDTO createExperienciaDTO) {
        ResponseExperienciaDTO nuevaExperiencia = experienciaService.registrarExperienciaProfesionalAutenticado(createExperienciaDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "Se registró correctamente la experiencia profesional", nuevaExperiencia);
    }

    @PutMapping("{uuid}")
    @Operation(summary = "Actualizar experiencia", description = "Actualiza una experiencia del usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizó correctamente la experiencia profesional"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la experiencia con el UUID proporcionado.")
            }
    )
    public ResponseEntity actualizarExperienciaProfesionalAutenticada(@Valid @RequestBody UpdateExperienceDTO updateExperienceDTO,
            @Parameter(description = "UUID de la experiencia.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String experienciaUUD) {
        ResponseExperienciaDTO experienciaUpdatedDTO =  experienciaService.actualizarExperienciaProfesionalAutenticada(updateExperienceDTO, experienciaUUD);
        return ResponseHandler.ok(TipoResponse.UPDATE, "Se actualizó correctamente la experiencia profesional", experienciaUpdatedDTO);
    }

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Eliminar experiencia", description = "Elimina una experiencia del usuario autenticado por su UUID.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se eliminó correctamente la experiencia profesional"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la experiencia con el UUID proporcionado.")
            }
    )
    public ResponseEntity eliminarExperienciaProfesionalAutenticado(
            @Parameter(description = "UUID de la experiencia.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String experienciaUUID) {
        experienciaService.eliminarExperienciaProfesionalAutenticado(experienciaUUID);
        return ResponseHandler.ok(TipoResponse.DELETE, "Se eliminó correctamente la experiencia profesional", null);
    }

    @GetMapping("/{uuid}/proyectos")
    @Operation(summary = "Obtener experiencia con sus proyectos", description = "Obtiene el detalle de una experiencia del usuario autenticado junto con los proyectos asociados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo correctamente el detalle de la experiencia profesional"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "404", description = "No se encontró la experiencia con el UUID proporcionado.")
            }
    )
    public ResponseEntity obtenerExperienciaConProyectosProfesionalAutenticado(
            @Parameter(description = "UUID de la experiencia.", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
            @PathVariable(name = "uuid") String experienciaUUID) {
        ResponseExperienciaConProyectosDTO experiencia = experienciaService.obtenerExperienciaConProyectosProfesionalAutenticado(experienciaUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo correctamente el detalle de la experiencia profesional", experiencia);
    }

}
