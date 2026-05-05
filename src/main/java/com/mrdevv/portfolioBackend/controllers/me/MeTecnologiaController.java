package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("me/tecnologias")
public class MeTecnologiaController {

    private final IProfesionalTecnologiaService profesionalTecnologiaService;

    @GetMapping()
    public ResponseEntity obtenerTecnologiasProfesionalAutenticado(@RequestParam(required = false) @Size(min = 2, message = "Mínimo 2 caracteres") String nombre){
        List<ResponseProfesionalTecnologiaDTO> tecnologias = profesionalTecnologiaService.obtenerTecnologiasProfesionalAutenticado(nombre);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las tecnologías del profesional correctamente", tecnologias);
    }
}
