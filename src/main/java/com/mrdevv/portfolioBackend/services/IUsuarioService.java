package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<ResponseUsuarioDTO> obtenerUsuarios();

    ResponseUsuarioDTO obtenerUsuario(Long usuarioId);

    void actualizarRol(Long usuarioId, UpdateRolUsuarioDTO rol);

    ResponseApiKeyUsuario generarApiKey(Long usuarioId);
}
