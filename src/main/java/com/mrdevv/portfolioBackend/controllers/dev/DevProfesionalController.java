package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev")
public class DevProfesionalController {

    private final IProfesionalService profesionalService;

    @GetMapping("me/datos")
    public ResponseEntity obtenerDatosProfesionales(){
        ResponseProfesionalDTO profesionalDTO = profesionalService.obtenerDatosProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo los datos profesionales correctamente", profesionalDTO);
    }
}
