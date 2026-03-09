package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("experiencias")
public class ExperienciaController {

    private final IExperienciaService experienciaService;

    @GetMapping
    public ResponseEntity obtenerExperiencias(){
        List<ResponseExperienciasDTO> experiencias = experienciaService.obtenerExperiencias();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron las experiencias correctamente", experiencias);
    }

}
