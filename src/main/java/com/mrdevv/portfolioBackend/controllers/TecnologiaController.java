package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IDesarrolladorTecnologiaService;
import com.mrdevv.portfolioBackend.services.ITecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("tecnologias")
public class TecnologiaController {

    private final ITecnologiaService tecnologiaService;
    private final IDesarrolladorTecnologiaService desarrolladorTecnologiaService;

    @GetMapping("/me")
    public ResponseEntity obtenerTecnologiasDesarrollador(@RequestParam(required = false) @Size(min = 2, message = "Mínimo 2 caracteres") String nombre){
        List<ResponseDesarrolladorTecnologia> tecnologias = desarrolladorTecnologiaService.obtenerTecnologiasDesarrollador(nombre);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías del desarrollador correctamente", tecnologias);
    }

    @GetMapping
    public ResponseEntity obtenerTecnologias(
            @RequestParam(required = false) @Size(min = 2, message = "Mínimo 2 caracteres") String nombre,
            @RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, name = "size", defaultValue = "8") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable tecnologiaList = tecnologiaService.obtenerTecnologias(nombre, pageable);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvieron las tecnologias correctamente", tecnologiaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTecnologiaPorId(@PathVariable(name = "id") Long tecnologiaId){
        ResponseTecnologiaDTO tecnologia = tecnologiaService.obtenerTecnologiaPorId(tecnologiaId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo la tecnología correctamente", tecnologia);
    }

}
