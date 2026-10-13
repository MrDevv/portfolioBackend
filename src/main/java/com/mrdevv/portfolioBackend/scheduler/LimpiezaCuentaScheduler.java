package com.mrdevv.portfolioBackend.scheduler;

import com.mrdevv.portfolioBackend.services.scheduler.ILimpiezaCuentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LimpiezaCuentaScheduler {

    private static final ZoneId ZONA = ZoneId.of("America/Lima");

    private final ILimpiezaCuentaService limpiezaCuentaService;

    @Scheduled(cron = "0 0 0 * * *", zone = "America/Lima")
    public void limpiarCuentasPendientes() {
        LocalDateTime ahora = LocalDateTime.now(ZONA);

        List<Long> candidatos;

        try {
            candidatos = limpiezaCuentaService.obtenerCandidatos(ahora);
        } catch (Exception exception) {
            log.error("No se pudieron consultar las cuentas pendientes", exception);
            return;
        }

        if (candidatos.isEmpty()) {
            log.info("No hay cuentas pendientes con token vencido");
            return;
        }

        int eliminados = 0;
        int omitidos = 0;
        int fallidos = 0;

        for (Long usuarioId : candidatos) {
            try {
                boolean eliminado = limpiezaCuentaService.eliminarCuenta(usuarioId, ahora);

                if (eliminado) {
                    eliminados++;
                } else {
                    omitidos++;
                }
            } catch (Exception exception) {
                fallidos++;

                log.error("No se pudo eliminar la cuenta pendiente {}", usuarioId, exception);
            }
        }

        log.info("Limpieza completada. Eliminados: {}. Omitidos: {}. Fallidos: {}", eliminados, omitidos, fallidos);
    }

}
