package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.dto.projection.UsuarioAuthPrincipalProjection;
import com.mrdevv.portfolioBackend.dto.projection.UsuarioProjectionDTO;
import com.mrdevv.portfolioBackend.dto.projection.UsuarioResumenProjection;
import com.mrdevv.portfolioBackend.dto.request.RegisterDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateOrigenPermitidoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseDashboardUsuarios;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.exceptions.ObjectReplicatedException;
import com.mrdevv.portfolioBackend.mappers.ProfesionalMapper;
import com.mrdevv.portfolioBackend.mappers.UsuarioMapper;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.services.IRolService;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import com.mrdevv.portfolioBackend.utils.constants.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final IRolService rolService;
    private final IProfesionalService profesionalService;
    private final PasswordEncoder PasswordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseUsuarioDTO> obtenerUsuarios() {
        List<UsuarioProjectionDTO> usuarios = usuarioRepository.obtenerUsuarios();
        return UsuarioMapper.toResonseUsuarioDTOList(usuarios);
    }

    @Transactional(readOnly = true)
    public Usuario findByUsuarioId(Long usuarioId) {
        return usuarioRepository.findByUsuarioId(usuarioId);
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

    @Transactional(readOnly = true)
    public UsuarioAuthPrincipal findUsuarioAuthPrincipalProjectionByEmail(String email){
        UsuarioAuthPrincipalProjection usuarioProjectionDTO = usuarioRepository.findUsuarioAuthPrincipalProjectionByEmail(email).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(email),
                ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage(email)
        ));

        GrantedAuthority authority =
                new SimpleGrantedAuthority("ROLE_" + usuarioProjectionDTO.getRol());

        return new UsuarioAuthPrincipal(
                usuarioProjectionDTO.getUsuarioId(),
                usuarioProjectionDTO.getProfesionalId(),
                usuarioProjectionDTO.getEmail(),
                null,
                null,
                usuarioProjectionDTO.getEstado(),
                List.of(authority)
        );
    }

    @Transactional
    @Override
    public ResponseApiKeyUsuario generarApiKey() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).usuarioId();

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

    @Transactional(readOnly = true)
    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(email),
                ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage(email)
        ));
    }

    @Transactional
    @Override
    public void revocarApiKey() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).usuarioId();

        if (!usuarioRepository.existsById(usuarioId)){
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(usuarioId),
                    ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage(usuarioId));
        }

        usuarioRepository.revocarApiKey(usuarioId);
    }

    @Transactional
    @Override
    public void actualizarOrigenPermitidoAutenticado(UpdateOrigenPermitidoDTO origenPermitido) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).usuarioId();
        if (!usuarioRepository.existsById(usuarioId)){
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_USUARIO_BACKEND.getMessage(usuarioId),
                    ErrorMessage.NOT_FOUND_USUARIO_FRONT.getMessage(usuarioId));

        }
        usuarioRepository.actualizarOrigenPermitido(usuarioId, origenPermitido.origenPermitido(), origenPermitido.estado());
    }

    @Transactional
    @Override
    public Usuario createUsuario(RegisterDTO registerDTO) {
        this.existeUsuarioPorEmail(registerDTO.email());
        Rol rol = rolService.findRolByDescripcion(Roles.USUARIO);

        Profesional profesional = profesionalService.crearProfesional(ProfesionalMapper.toProfesionalEntity(registerDTO));
        Usuario usuario = UsuarioMapper.toUsuarioEntity(registerDTO, profesional, rol);
        usuario.setPassword(PasswordEncoder.encode(registerDTO.password()));
        System.out.println(usuario);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public void existeUsuarioPorEmail(String email) {
        if (usuarioRepository.existeUsuarioByEmail(email)) {
            throw new ObjectReplicatedException(
                    ErrorMessage.REPLICATED_USUARIO_BACKEND.getMessage(email),
                    ErrorMessage.REPLICATED_USUARIO_FRONT.getMessage(email)
            );
        }
    }

    @Transactional
    @Override
    public void activarCuentaUsuario(Long usuarioId) {
        usuarioRepository.activarCuentaUsuario(usuarioId);
    }

    @Transactional
    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDashboardUsuarios obtenerResumenUsuarios() {
        UsuarioResumenProjection resumen = usuarioRepository.obtenerResumen();
        return new ResponseDashboardUsuarios(
                resumen.getTotalUsuarios(),
                resumen.getTotalActivos(),
                resumen.getTotalPendientes(),
                resumen.getTotalInactivos()
        );
    }


}
