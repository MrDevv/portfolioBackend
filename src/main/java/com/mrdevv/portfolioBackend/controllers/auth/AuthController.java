package com.mrdevv.portfolioBackend.controllers.auth;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.request.*;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.impl.AuthServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
@Tag(name = "Autenticación", description = "Operaciones de registro, inicio de sesión, activación de cuenta y recuperación de contraseña")
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("login")
    @SecurityRequirements
    @Operation(summary = "Iniciar sesión", description = "Autentica al usuario con su correo y contraseña. Devuelve los datos del usuario junto con el token JWT que debe usarse en los demás endpoints. Endpoint público.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se autenticó el usuario correctamente. La propiedad 'data' contiene los datos del usuario y el token JWT."),
                    @ApiResponse(responseCode = "401", description = "Credenciales incorrectas. El correo o la contraseña no son válidos."),
                    @ApiResponse(responseCode = "403", description = "Acceso denegado. La cuenta está pendiente de verificación de correo o se encuentra inactiva.")
            }
    )
    public ResponseEntity login(@RequestBody AuthDTO authDTO){
        ResponseUsuarioLoginDTO usuario = authService.login(authDTO);
        return ResponseHandler.ok(TipoResponse.GET, "se autenticó el usuario correctamente", usuario);
    }

    @PostMapping("register")
    @SecurityRequirements
    @Operation(summary = "Registrar usuario", description = "Registra un nuevo usuario y envía un correo con el enlace de confirmación de la cuenta, el cual es válido por 24 horas. Endpoint público.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Se registró el usuario correctamente. Se envió el correo de confirmación."),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. Faltan campos obligatorios o la contraseña y su confirmación no coinciden."),
                    @ApiResponse(responseCode = "409", description = "Conflicto. Ya existe un usuario registrado con el correo proporcionado.")
            }
    )
    public ResponseEntity register(@Valid @RequestBody RegisterDTO registerDTO){
        authService.register(registerDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "se registró el usuario correctamente", null);
    }

    @PatchMapping("activar-cuenta")
    @SecurityRequirements
    @Operation(summary = "Activar cuenta", description = "Activa la cuenta del usuario a partir del token recibido por correo electrónico. Endpoint público.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se activó la cuenta correctamente."),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El token es obligatorio, ha expirado o ya fue utilizado."),
                    @ApiResponse(responseCode = "404", description = "No se encontró el token proporcionado.")
            }
    )
    public ResponseEntity activarCuenta(@RequestBody ConfirmAccountDTO confirmAccountDTO){
        authService.activarCuenta(confirmAccountDTO.token());
        return ResponseHandler.ok(TipoResponse.PATCH, "se activó la cuenta correctamente", null);
    }

    @GetMapping("validate-token")
    @Operation(summary = "Validar token", description = "Valida el token JWT enviado en la cabecera Authorization y devuelve los datos del usuario autenticado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Token válido. La propiedad 'data' contiene los datos del usuario autenticado."),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED)
            }
    )
    public ResponseEntity validateToken(){
        ResponseUsuarioLoginDTO usuarioLoginDTO = authService.validateToken();
        return ResponseHandler.ok(TipoResponse.GET, "datos del usuario autenticado", usuarioLoginDTO);
    }

    @PostMapping("recuperar-password")
    @SecurityRequirements
    @Operation(summary = "Solicitar recuperación de contraseña", description = "Envía un correo con un enlace para restablecer la contraseña, válido por 24 horas. Endpoint público.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se envió el correo para recuperar la contraseña."),
                    @ApiResponse(responseCode = "404", description = "No se encontró un usuario con el correo proporcionado.")
            }
    )
    public ResponseEntity recuperarPassword(@RequestBody RecoverPasswordDTO recoverPasswordDTO){
        authService.recuperarPassword(recoverPasswordDTO.email());
        return ResponseHandler.ok(TipoResponse.GET, "se envió el correo para recuperar la contraseña", null);
    }

    @PatchMapping("reset-password")
    @SecurityRequirements
    @Operation(summary = "Restablecer contraseña", description = "Establece una nueva contraseña utilizando el token recibido por correo electrónico. Endpoint público.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se restableció la contraseña correctamente."),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida. El token ha expirado o no es válido."),
                    @ApiResponse(responseCode = "404", description = "No se encontró el token proporcionado.")
            }
    )
    public ResponseEntity resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        authService.resetPassword(resetPasswordDTO.token(), resetPasswordDTO.password());
        return ResponseHandler.ok(TipoResponse.PATCH, "se restableció la contraseña correctamente", null);
    }

}
