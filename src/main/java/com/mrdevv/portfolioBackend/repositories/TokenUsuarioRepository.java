package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.TokenUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenUsuarioRepository extends JpaRepository<TokenUsuario, String> {

    @Query(value = "SELECT t FROM TokenUsuario t join t.usuario u WHERE t.token = :token AND t.tipoToken = :tipoToken")
    TokenUsuario obtenerTokenUsuario(@Param("token") String token,  @Param("tipoToken") String tipoToken);

    @Modifying
    @Query("DELETE FROM TokenUsuario t WHERE t.usuario.usuarioId = :usuarioId")
    int eliminarPorUsuario(@Param("usuarioId") Long usuarioId);

}
