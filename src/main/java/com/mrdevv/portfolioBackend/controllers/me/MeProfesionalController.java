package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me")
public class MeProfesionalController {

    private final IProfesionalService profesionalService;

    @GetMapping("/datos")
    public ResponseEntity<Object> obtenerDatosProfesionales(){
        ResponseProfesionalDTO profesionalDTO = profesionalService.obtenerDatosProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los datos profesionales correctamente", profesionalDTO);
    }

    @PutMapping("/datos")
    public ResponseEntity<Object> actualizarDatosProfesionales(@RequestBody UpdateProfesionalDTO updateProfesionalDTO){
        ResponseProfesionalDTO profesionalDTO = profesionalService.actualizarProfesionalAutenticado(updateProfesionalDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "se actualizaron los datos profesionales correctamente", profesionalDTO);
    }
}
