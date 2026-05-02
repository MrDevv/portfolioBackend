package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.UpdateDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaSimpleDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.models.DesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.services.*;
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
    private final ITecnologiaService tecnologiaService;
    private final IDesarrolladorTecnologiaService desarrolladorTecnologiaService;

    @GetMapping
    public ResponseEntity<Object> obtenerDesarrolladores(){
        List<ResponseDesarrolladorDTO> desarrolladorDTOS = desarrolladorService.obtenerDesarrolladores();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los desarrolladores correctamente", desarrolladorDTOS);
    }

    @PutMapping()
    public ResponseEntity<Object> actualizarDesarrollador(@RequestBody UpdateDesarrolladorDTO updateDesarrolladorDTO){
        ResponseDesarrolladorDTO desarrolladorDTO = desarrolladorService.actualizarDesarrollador(updateDesarrolladorDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "se actualizó el desarrollador correctamente", desarrolladorDTO);
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
        ResponseWithPageable proyectosDTO = proyectoService.obtenerProyectos(pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron los proyectos correctamente", proyectosDTO);
    }

    @GetMapping("me/tecnologias")
    public ResponseEntity obtenerTecnologiasDesarrollador(){
        List<ResponseDesarrolladorTecnologia> tecnologias = desarrolladorTecnologiaService.obtenerTecnologiasDesarrollador(null);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías correctamente", tecnologias);
    }

}
