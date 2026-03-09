package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.ITecnologiaService;
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
@RequestMapping("tecnologias")
public class TecnologiaController {

    private final ITecnologiaService tecnologiaService;

    @GetMapping
    public ResponseEntity obtenerTecnologias(){
        List<ResponseTecnologiaDTO> tecnologias = tecnologiaService.obtenerTecnologias();
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías correctamente", tecnologias);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTiposProyecto(@PathVariable(name = "id") Long tecnologiaId){
        ResponseTecnologiaDTO tecnologia = tecnologiaService.obtenerTecnologiaPorId(tecnologiaId);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo la tecnología correctamente", tecnologia);
    }

}
