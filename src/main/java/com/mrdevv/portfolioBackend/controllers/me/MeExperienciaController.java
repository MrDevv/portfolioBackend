package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaCreatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me/experiencias")
public class MeExperienciaController {

    private final IExperienciaService experienciaService;

    @GetMapping
    public ResponseEntity obtenerExperienciasProfesionalAutenticado(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
                                                                     @RequestParam(name = "size", defaultValue = "4", required = false) Integer size,
                                                                    @RequestParam(name = "nombre_empresa", required = false) String nombreEmpresa){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable experiencias = experienciaService.obtenerExperienciasProfesionalAutenticado(nombreEmpresa, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron las experiencias correctamente", experiencias);
    }

    @PostMapping
    public ResponseEntity registrarExperienciaProfesionalAutenticado(@Valid @RequestBody CreateExperienciaDTO createExperienciaDTO) {
        ResponseExperienciaCreatedDTO nuevaExperiencia = experienciaService.registrarExperienciaProfesionalAutenticado(createExperienciaDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "Se registró correctamente la experiencia profesional", nuevaExperiencia);
    }

}
