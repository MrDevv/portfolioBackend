package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.ITipoProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("tipos-proyectos")
public class TipoProyectoController {

    private final ITipoProyectoService proyectoService;

    @GetMapping
    public ResponseEntity obtenerTiposProyectos(){
        List<ResponseTipoProyectoDTO> tipoProyectos = proyectoService.obtenerTiposProyectos();
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los tipos de proyectos correctamente", tipoProyectos);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTiposProyecto(@PathVariable(name = "id") Long tipoProyectoId){
        ResponseTipoProyectoDTO tipoProyecto = proyectoService.obtenerTipoProyectoPorId(tipoProyectoId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo el tipo de proyecto correctamente", tipoProyecto);
    }

}
