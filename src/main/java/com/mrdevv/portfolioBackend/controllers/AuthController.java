package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.impl.AuthServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
