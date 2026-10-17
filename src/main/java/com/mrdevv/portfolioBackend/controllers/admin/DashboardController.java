package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.dto.response.ResponseDashboard;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IDashboardService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/dashboard")
public class DashboardController {

    private final IDashboardService dashboardService;

    @GetMapping
    public ResponseEntity obtenerResumenDashboard() {
        ResponseDashboard responseDashboard = dashboardService.getDatosDashboard();
        return ResponseHandler.ok(TipoResponse.GET, "Resumen del dashboard obtenido correctamente", responseDashboard);
    }

}
