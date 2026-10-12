package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.models.Usuario;

import java.time.LocalDateTime;

public interface ITokenUsuarioService {

    void registrarTokenUsuario(String token, Usuario usuario, String tipoToken,  LocalDateTime fechaExpiracion);

}
