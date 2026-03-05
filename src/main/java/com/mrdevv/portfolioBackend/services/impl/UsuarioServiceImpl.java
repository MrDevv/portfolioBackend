package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.UsuarioMapper;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolServiceImpl rolService;

    @Override
    public List<ResponseUsuarioDTO> obtenerUsuarios() {
        List<Object[]> usuarios = usuarioRepository.obtenerUsuarios();
        return UsuarioMapper.toResonseUsuarioDTOList(usuarios);
    }

    @Override
    public ResponseUsuarioDTO obtenerUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> {
            throw new ObjectNotFoundException("No se encontró la usuario", "no se encontró al usuairo");
        });
        return UsuarioMapper.toResponseUsuario(usuario);
    }

    @Transactional
    @Override
    public void actualizarRol(Long usuarioId, UpdateRolUsuarioDTO rolDto) {
        Rol rolEntity = rolService.findRolByDescripcion(rolDto.rol());

        if(!usuarioRepository.existsById(usuarioId)){
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(),
                    ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage());
        }

        usuarioRepository.actualizarRol(usuarioId, rolEntity);
    }
}
