package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @Transactional(readOnly = true)
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

    @Transactional
    @Override
    public ResponseApiKeyUsuario generarApiKey(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)){
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(usuarioId),
                    ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage(usuarioId));
        }

        LocalDateTime fechaActual = LocalDateTime.now();
        String day = String.valueOf(fechaActual.getDayOfMonth());
        String month = String.valueOf(fechaActual.getMonthValue());
        String year = String.valueOf(fechaActual.getYear());
        String hour = String.valueOf(fechaActual.getHour());
        String minutes = String.valueOf(fechaActual.getMinute());
        String seconds = String.valueOf(fechaActual.getSecond());
        String uuid = UUID.randomUUID().toString();

        String apiKey = uuid.concat("-")
                .concat(day)
                .concat(month)
                .concat(year)
                .concat(hour)
                .concat(minutes)
                .concat(seconds);

        usuarioRepository.crearApiKey(usuarioId, apiKey);

        return new ResponseApiKeyUsuario(apiKey);
    }
}
