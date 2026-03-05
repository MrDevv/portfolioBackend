package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IDesarrolladorService;
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
@RequestMapping("desarrolladores")
public class DesarrolladorController {

    private final IDesarrolladorService desarrolladorService;

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

}
