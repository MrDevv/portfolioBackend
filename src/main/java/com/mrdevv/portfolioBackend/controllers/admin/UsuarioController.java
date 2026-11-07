package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.impl.UsuarioServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/usuarios")
@Tag(name = "Admin - Usuarios", description = "Gestión de usuarios. Requiere el rol de administrador")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping
    @Operation(summary = "Obtener usuarios", description = "Obtiene la lista de todos los usuarios registrados.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los usuarios correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_ADMIN)
            }
    )
    public ResponseEntity obtenerUsuarios(){
        List<ResponseUsuarioDTO> usuarios = usuarioService.obtenerUsuarios();
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los usuarios correctamente", usuarios);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar rol de usuario", description = "Actualiza el rol de un usuario por su identificador.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se actualizó el rol del usuario correctamente"),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El rol enviado no es válido o el identificador no es numérico."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_ADMIN),
                    @ApiResponse(responseCode = "404", description = "No se encontró el usuario con el identificador proporcionado.")
            }
    )
    public ResponseEntity actualizarRolUsuario(
            @Parameter(description = "Identificador numérico del usuario.", example = "1")
            @PathVariable(name = "id") Long usuarioId, @RequestBody UpdateRolUsuarioDTO rol){
        usuarioService.actualizarRol(usuarioId, rol);
        return ResponseHandler.ok(TipoResponse.PATCH, "Se actualizó el rol del usuario correctamente", null);
    }

}
