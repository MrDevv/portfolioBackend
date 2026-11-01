package com.mrdevv.portfolioBackend.controllers.auth;

import com.mrdevv.portfolioBackend.dto.request.*;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.impl.AuthServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO){
        ResponseUsuarioLoginDTO usuario = authService.login(authDTO);
        return ResponseHandler.ok(TipoResponse.GET, "se autenticó el usuario correctamente", usuario);
    }

    @PostMapping("register")
    public ResponseEntity register(@Valid @RequestBody RegisterDTO registerDTO){
        authService.register(registerDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "se registró el usuario correctamente", null);
    }

    @PatchMapping("activar-cuenta")
    public ResponseEntity activarCuenta(@RequestBody ConfirmAccountDTO confirmAccountDTO){
        authService.activarCuenta(confirmAccountDTO.token());
        return ResponseHandler.ok(TipoResponse.PATCH, "se activó la cuenta correctamente", null);
    }

    @GetMapping("validate-token")
    public ResponseEntity validateToken(){
        ResponseUsuarioLoginDTO usuarioLoginDTO = authService.validateToken();
        return ResponseHandler.ok(TipoResponse.GET, "datos del usuario autenticado", usuarioLoginDTO);
    }

    @PostMapping("recuperar-password")
    public ResponseEntity recuperarPassword(@RequestBody RecoverPasswordDTO recoverPasswordDTO){
        authService.recuperarPassword(recoverPasswordDTO.email());
        return ResponseHandler.ok(TipoResponse.GET, "se envió el correo para recuperar la contraseña", null);
    }

    @PatchMapping("reset-password")
    public ResponseEntity resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        authService.resetPassword(resetPasswordDTO.token(), resetPasswordDTO.password());
        return ResponseHandler.ok(TipoResponse.PATCH, "se restableció la contraseña correctamente", null);
    }

}
