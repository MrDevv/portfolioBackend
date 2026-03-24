package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IDesarrolladorService;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("desarrolladores")
public class DesarrolladorController {

    private final IDesarrolladorService desarrolladorService;
    private final IExperienciaService experienciaService;
    private final IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<Object> obtenerDesarrolladores(){
        List<ResponseDesarrolladorDTO> desarrolladorDTOS = desarrolladorService.obtenerDesarrolladores();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los desarrolladores correctamente", desarrolladorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerDesarrolladorPorId(@PathVariable(name = "id") Long desarrolladorId){
        ResponseDesarrolladorDTO desarrolladorDTO = desarrolladorService.obtenerDesarrolladorById(desarrolladorId);
        return ResponseHandler.ok(TipoResponse.GET, "se obtuvieron los datos del desarrollador correctamente", desarrolladorDTO);
    }

    @GetMapping("me/datos")
    public ResponseEntity obtenerDatos(){
        ResponseDesarrolladorDTO desarrolladorDTO = desarrolladorService.obtenerDatosDesarrollador();
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo los datos del desarrollador correctamente", desarrolladorDTO);
    }

    @GetMapping("me/experiencias")
    public ResponseEntity obtenerExperienciasDesarrollador(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
                                              @RequestParam(name = "size", defaultValue = "4", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable experienciasDTO = experienciaService.obtenerExperiencias(pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las experiencias correctamente", experienciasDTO);
    }

    @GetMapping("me/proyectos")
    public ResponseEntity obtenerProyectosDesarrollado(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
                                                       @RequestParam(name = "size", defaultValue = "4", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectosDTO = proyectoService.obtenerProyectos(null, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los proyectos correctamente", proyectosDTO);
    }

}
