package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.RegisterDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateOrigenPermitidoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseDashboardUsuarios;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.models.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<ResponseUsuarioDTO> obtenerUsuarios();

    void actualizarRol(Long usuarioId, UpdateRolUsuarioDTO rol);

    Usuario findByEmail(String email);

    ResponseApiKeyUsuario generarApiKey();

    void revocarApiKey();

    void actualizarOrigenPermitidoAutenticado(UpdateOrigenPermitidoDTO origenPermitido);

    Usuario createUsuario(RegisterDTO registerDTO);

    void existeUsuarioPorEmail(String email);

    void activarCuentaUsuario(Long usuarioId);

    void eliminarUsuario(Usuario usuario);

    ResponseDashboardUsuarios obtenerResumenUsuarios();
}
