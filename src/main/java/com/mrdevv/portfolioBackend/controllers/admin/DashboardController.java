package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.config.swagger.ApiDocs;
import com.mrdevv.portfolioBackend.dto.response.ResponseDashboard;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IDashboardService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/dashboard")
@Tag(name = "Admin - Dashboard", description = "Métricas generales de la plataforma. Requiere el rol de administrador")
public class DashboardController {

    private final IDashboardService dashboardService;

    @GetMapping
    @Operation(summary = "Obtener resumen del dashboard", description = "Obtiene el resumen de usuarios (total, activos, pendientes e inactivos) y de contenido (experiencias y proyectos).")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Resumen del dashboard obtenido correctamente"),
                    @ApiResponse(responseCode = "401", description = ApiDocs.UNAUTHORIZED),
                    @ApiResponse(responseCode = "403", description = ApiDocs.FORBIDDEN_ADMIN)
            }
    )
    public ResponseEntity obtenerResumenDashboard() {
        ResponseDashboard responseDashboard = dashboardService.getDatosDashboard();
        return ResponseHandler.ok(TipoResponse.GET, "Resumen del dashboard obtenido correctamente", responseDashboard);
    }

}
