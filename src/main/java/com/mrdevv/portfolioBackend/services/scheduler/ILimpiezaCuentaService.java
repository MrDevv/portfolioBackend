package com.mrdevv.portfolioBackend.services.scheduler;

import java.time.LocalDateTime;
import java.util.List;

public interface ILimpiezaCuentaService {
    List<Long> obtenerCandidatos(LocalDateTime ahora);

    boolean eliminarCuenta(Long usuarioId, LocalDateTime ahora);
}
