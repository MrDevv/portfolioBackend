package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.UsuarioAuthPrincipalProjection;
import com.mrdevv.portfolioBackend.dto.projection.UsuarioProjectionDTO;
import com.mrdevv.portfolioBackend.dto.projection.UsuarioResumenProjection;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    Usuario findByUsuarioId(Long usuarioId);

    @Query(value = """
        select 
            u.usuarioId as usuarioId,
            p.profesionalId as profesionalId,
            u.email as email,
            u.origenPermitido as origenPermitido,
            u.estadoOrigen as estadoOrigen,
            u.estado as estado,
            r.descripcion as rol
        from Usuario u
        join u.profesional p
        join u.rol r
        where u.apiKey = :apiKey
    """)
    Optional<UsuarioAuthPrincipalProjection> findUsuarioAuthPrincipalProjectionByApiKey(String apiKey);

    @Query(value = """
        select 
            u.usuarioId as usuarioId,
            p.profesionalId as profesionalId,
            u.email as email,
            u.estado as estado,
            r.descripcion as rol
        from Usuario u
        join u.profesional p
        join u.rol r
        where u.email = :email
    """)
    Optional<UsuarioAuthPrincipalProjection> findUsuarioAuthPrincipalProjectionByEmail(String email);

    @Modifying
    @Query(value = "update Usuario u set u.apiKey = null where u.usuarioId = :usuarioId")
    void revocarApiKey(@Param("usuarioId") Long usuarioId);

    @Modifying
    @Query(value = "update Usuario u set u.origenPermitido = :origenPermitido, u.estadoOrigen = :estado where u.usuarioId = :usuarioId")
    void actualizarOrigenPermitido(@Param("usuarioId") Long usuarioId, @Param("origenPermitido") String origenPermitido, @Param("estado") Boolean estado);

    @Query(value = "select count(u) > 0 from Usuario u where u.email = :email")
    boolean existeUsuarioByEmail(@Param("email") String email);

    @Modifying
    @Query(value = "update Usuario u set u.estado = 'activo' where u.usuarioId = :usuarioId")
    void activarCuentaUsuario(@Param("usuarioId") Long usuarioId);

//    querys para tareas programadas
    @Query(value = """
            SELECT u.usuarioId
            FROM Usuario u
            WHERE u.estado = 'pendiente'
              AND EXISTS (
                  SELECT t
                  FROM TokenUsuario t
                  WHERE t.usuario = u
                    AND t.tipoToken = 'CONFIRMAR_CUENTA'
                    AND t.fechaExpiracion <= :ahora
              )
            ORDER BY u.usuarioId
            """)
    List<Long> obtenerIdsPendientesConTokenVencido(@Param("ahora") LocalDateTime ahora);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = """
        SELECT u
        FROM Usuario u
        WHERE u.usuarioId = :usuarioId
          AND u.estado = 'pendiente'
          AND EXISTS (
              SELECT t
              FROM TokenUsuario t
              WHERE t.usuario = u
                AND t.tipoToken = 'CONFIRMAR_CUENTA'
                AND t.fechaExpiracion <= :ahora
          )
        """)
    Optional<Usuario> obtenerPendienteVencidoConBloqueo(@Param("usuarioId") Long usuarioId, @Param("ahora") LocalDateTime ahora);

    // Para coordinar la confirmación con la limpieza.
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT u
        FROM Usuario u
        WHERE u.usuarioId = :usuarioId
        """)
    Optional<Usuario> buscarPorIdConBloqueo(@Param("usuarioId") Long usuarioId);


    @Query(value = """
        SELECT 
            COUNT(u) as totalUsuarios,
            COALESCE(SUM(CASE WHEN u.estado = 'activo' THEN 1 ELSE 0 END), 0) AS totalActivos,
            COALESCE(SUM(CASE WHEN u.estado = 'pendiente' THEN 1 ELSE 0 END), 0) AS totalPendientes,
            COALESCE(SUM(CASE WHEN u.estado = 'inactivo' THEN 1 ELSE 0 END), 0) AS totalInactivos
        FROM Usuario u join u.rol r 
        WHERE r.descripcion = 'user'
    """)
    UsuarioResumenProjection obtenerResumen();
}
