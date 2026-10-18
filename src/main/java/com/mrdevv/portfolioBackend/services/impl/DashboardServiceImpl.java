package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.response.ResponseDashboard;
import com.mrdevv.portfolioBackend.dto.response.ResponseDashboardContenido;
import com.mrdevv.portfolioBackend.dto.response.ResponseDashboardUsuarios;
import com.mrdevv.portfolioBackend.services.IDashboardService;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements IDashboardService {

    private final IUsuarioService usuarioService;
    private final IExperienciaService experienciaService;
    private final IProyectoService proyectoService;

    @Transactional(readOnly = true)
    @Override
    public ResponseDashboard getDatosDashboard() {
        ResponseDashboardUsuarios resumenUsuarios = usuarioService.obtenerResumenUsuarios();
        Long totalExperiencias = experienciaService.obtenerTotalExperiencias();
        Long totalProyectos = proyectoService.obtenerTotalProyectos();
        return new ResponseDashboard(resumenUsuarios, new ResponseDashboardContenido(totalExperiencias, totalProyectos));
    }
}
