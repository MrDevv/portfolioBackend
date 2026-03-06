package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select u.usuarioId, u.username, " +
            "d.nombres, d.apellidos, d.puesto, " +
            "r.rolId, r.descripcion, u.estado, " +
            "u.apiKey " +
            "from Usuario u join u.desarrollador d " +
            "join u.rol r")
    List<Object[]> obtenerUsuarios();

    @Modifying
    @Query(value = "update Usuario u set u.rol = :rol where u.usuarioId = :usuarioId")
    void actualizarRol(@Param("usuarioId") Long usuarioId, @Param("rol") Rol rol);

    @Modifying
    @Query(value = "update Usuario u set u.apiKey = :apiKey where u.usuarioId = :usuarioId")
    void crearApiKey(@Param("usuarioId") Long usuarioId, @Param("apiKey") String apiKey);
}
