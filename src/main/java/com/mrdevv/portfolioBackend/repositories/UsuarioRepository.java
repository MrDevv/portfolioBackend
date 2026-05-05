package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.UsuarioProjectionDTO;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select " +
            "p.nombres as nombres, p.apellidos as apellidos, u.email as email, " +
            "p.puesto as puesto, r.descripcion as rol, u.estado as estado " +
            "from Usuario u join u.profesional p " +
            "join u.rol r")
    List<UsuarioProjectionDTO> obtenerUsuarios();

    @Modifying
    @Query(value = "update Usuario u set u.rol = :rol where u.usuarioId = :usuarioId")
    void actualizarRol(@Param("usuarioId") Long usuarioId, @Param("rol") Rol rol);

    @Modifying
    @Query(value = "update Usuario u set u.apiKey = :apiKey where u.usuarioId = :usuarioId")
    void crearApiKey(@Param("usuarioId") Long usuarioId, @Param("apiKey") String apiKey);

    @EntityGraph(attributePaths = {"profesional", "rol"})
    Optional<Usuario> findByEmail(String email);

    @EntityGraph(attributePaths = {})
    Optional<Usuario> findByApiKey(String apiKey);
}
