package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.impl.AuthServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
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

    @GetMapping("validate-token")
    public ResponseEntity validateToken(){
        ResponseUsuarioLoginDTO usuarioLoginDTO = authService.validateToken();
        return ResponseHandler.ok(TipoResponse.GET, "datos del usuario autenticado", usuarioLoginDTO);
    }

}
