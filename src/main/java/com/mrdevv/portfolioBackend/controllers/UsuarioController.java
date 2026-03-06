package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.impl.UsuarioServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity obtenerUsuarios(){
        List<ResponseUsuarioDTO> usuarios = usuarioService.obtenerUsuarios();
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los usuarios correctamente", usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable(name = "id") Long usuarioId){
        ResponseUsuarioDTO usuario = usuarioService.obtenerUsuario(usuarioId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo el usuario correctamente", usuario);
    }

    @PatchMapping("/{id}")
    public ResponseEntity actualizarRolUsuario(@PathVariable(name = "id") Long usuarioId, @RequestBody UpdateRolUsuarioDTO rol){
        usuarioService.actualizarRol(usuarioId, rol);
        return ResponseHandler.ok(TipoResponse.PATCH, "Se actualizó el rol del usuario correctamente", null);
    }

    @PostMapping("/{id}/generar-api-key")
    public ResponseEntity generarApiKey(@PathVariable(name = "id") Long usuarioId){
        ResponseApiKeyUsuario apiKey = usuarioService.generarApiKey(usuarioId);
        return ResponseHandler.ok(TipoResponse.PATCH, "Se generó la api key del usuario correctamente", apiKey);
    }

}
