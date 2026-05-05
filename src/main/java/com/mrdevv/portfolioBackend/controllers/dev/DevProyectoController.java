package com.mrdevv.portfolioBackend.controllers.dev;

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
@RequestMapping("dev/me/proyectos")
public class DevProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping()
    public ResponseEntity obtenerProyectosProfesional(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
                                                       @RequestParam(name = "size", defaultValue = "4", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectosDTO = proyectoService.obtenerProyectosProfesionalAutenticado(pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los proyectos correctamente", proyectosDTO);
    }
}
