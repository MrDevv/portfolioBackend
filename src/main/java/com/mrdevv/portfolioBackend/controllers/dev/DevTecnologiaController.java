package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev/me/tecnologias")
public class DevTecnologiaController {

    private final IProfesionalTecnologiaService profesionalTecnologiaService;

    @GetMapping()
    public ResponseEntity obtenerTecnologiasProfesional(){
        List<ResponseProfesionalTecnologiaDTO> tecnologias = profesionalTecnologiaService.obtenerTecnologiasProfesionalAutenticado(null);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías correctamente", tecnologias);
    }
}
