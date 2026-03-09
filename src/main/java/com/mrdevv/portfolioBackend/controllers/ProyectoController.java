package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.models.Proyecto;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("proyectos")
public class ProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity obtenerProyectos(){
        List<Proyecto> proyectos = proyectoService.obtenerProyectos();
        proyectos.forEach(proyecto -> {
            System.out.println(proyecto);
        });
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los proyectos correctamente", proyectos);
    }

}
