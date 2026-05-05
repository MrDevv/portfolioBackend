package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("admin/proyectos")
public class ProyectoController {

    private final IProyectoService proyectoService;


}
