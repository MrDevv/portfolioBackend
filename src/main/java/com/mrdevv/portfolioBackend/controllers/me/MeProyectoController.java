package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("me/proyectos")
public class MeProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity obtenerProyectosProfesionalAutenticado(@RequestParam(name = "usuarioId", required = false) Long usurioId,
                                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectos = proyectoService.obtenerProyectosProfesionalAutenticado(pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los proyectos correctamente", proyectos);
    }
}
