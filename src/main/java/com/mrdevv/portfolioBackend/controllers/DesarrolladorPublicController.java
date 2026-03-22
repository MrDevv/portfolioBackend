package com.mrdevv.portfolioBackend.controllers;

import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.DesarrolladorPublicoServiceImpl;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("public/desarrolladores")
public class DesarrolladorPublicController {

    private final DesarrolladorPublicoServiceImpl desarrolladorPublicoService;

    @GetMapping("datos")
    public ResponseEntity obtenerDatos(){
        ResponseDesarrolladorDTO desarrolladorDTO = desarrolladorPublicoService.obtenerDatosDesarrollador();
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo los datos del desarrollador correctamente", desarrolladorDTO);
    }
}
