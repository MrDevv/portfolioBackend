package com.mrdevv.portfolioBackend.controllers.dev;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("dev/me/experiencias")
public class DevExperienciaController {

    private final IExperienciaService experienciaService;

    @GetMapping()
    public ResponseEntity obtenerExperienciasProfesional(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
                                                           @RequestParam(name = "size", defaultValue = "4", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable experienciasDTO = experienciaService.obtenerExperienciasProfesionalAutenticado(null, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las experiencias correctamente", experienciasDTO);
    }
}
