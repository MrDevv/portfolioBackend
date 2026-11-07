package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.request.UpdateOrigenPermitidoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me")
@Tag(name = "Perfil profesional - usuario autenticado", description = "Operaciones sobre los datos profesionales, la API key y el origen permitido del usuario autenticado")
public class MeProfesionalController {

    private final IProfesionalService profesionalService;
    private final IUsuarioService usuarioService;

    @GetMapping("/datos")
    @Operation(summary = "Obtener datos profesionales", description = "Obtiene los datos profesionales del usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los datos profesionales correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity<Object> obtenerDatosProfesionales(){
        ResponseProfesionalDTO profesionalDTO = profesionalService.obtenerDatosProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los datos profesionales correctamente", profesionalDTO);
    }

    @PutMapping("/datos")
    @Operation(summary = "Actualizar datos profesionales", description = "Actualiza los datos profesionales del usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizaron los datos profesionales correctamente"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity<Object> actualizarDatosProfesionales(@RequestBody UpdateProfesionalDTO updateProfesionalDTO){
        ResponseProfesionalDTO profesionalDTO = profesionalService.actualizarProfesionalAutenticado(updateProfesionalDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "se actualizaron los datos profesionales correctamente", profesionalDTO);
    }

    @PostMapping("/api-key")
    @Operation(summary = "Generar API key", description = "Genera una nueva API key para el usuario autenticado. Se usa para consumir los endpoints 'dev/**'. El valor solo se muestra en esta respuesta.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Se generó la API key correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity<Object> generarApiKey(){
        ResponseApiKeyUsuario apiKey = usuarioService.generarApiKey();
        return ResponseHandler.ok(TipoResponse.CREATE, "se generó la API key correctamente", apiKey);
    }

    @DeleteMapping("/api-key")
    @Operation(summary = "Revocar API key", description = "Elimina la API key del usuario autenticado. Deja de ser válida para los endpoints 'dev/**'.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se eliminó la API key correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity<Object> eliminarApiKey(){
        usuarioService.revocarApiKey();
        return ResponseHandler.ok(TipoResponse.DELETE, "se eliminó la API key correctamente", null);
    }

    @PatchMapping("/origen-permitido")
    @Operation(summary = "Actualizar origen permitido", description = "Configura el origen (cabecera Origin) desde el cual se permite usar la API key y si la restricción está activa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizó el origen permitido correctamente"),
                    @ApiResponse(responseCode = "400", description = ApiDocs.BAD_REQUEST),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity<Object> actualizarOrigenPermitido(@RequestBody UpdateOrigenPermitidoDTO origenPermitido){
        usuarioService.actualizarOrigenPermitidoAutenticado(origenPermitido);
        return ResponseHandler.ok(TipoResponse.UPDATE, "se actualizó el origen permitido correctamente", null);
    }

}
