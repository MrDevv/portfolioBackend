package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaCreatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaUpdatedDTO;
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

    @GetMapping("/{uuid}")
    public ResponseEntity obtenerExperienciaProfesionalAutenticada(@PathVariable(name = "uuid") String experienciaUUID) {
        ResponseExperienciaDTO experiencia = experienciaService.obtenerExperienciaProfesionalAutenticado(experienciaUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo correctamente la experiencia profesional", experiencia);
    }

    @PostMapping
    public ResponseEntity registrarExperienciaProfesionalAutenticado(@Valid @RequestBody CreateExperienciaDTO createExperienciaDTO) {
        ResponseExperienciaDTO nuevaExperiencia = experienciaService.registrarExperienciaProfesionalAutenticado(createExperienciaDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "Se registró correctamente la experiencia profesional", nuevaExperiencia);
    }

    @PutMapping("{uuid}")
    public ResponseEntity actualizarExperienciaProfesionalAutenticada(@Valid @RequestBody UpdateExperienceDTO updateExperienceDTO, @PathVariable(name = "uuid") String experienciaUUD) {
        ResponseExperienciaDTO experienciaUpdatedDTO =  experienciaService.actualizarExperienciaProfesionalAutenticada(updateExperienceDTO, experienciaUUD);
        return ResponseHandler.ok(TipoResponse.UPDATE, "Se actualizó correctamente la experiencia profesional", experienciaUpdatedDTO);
    }

}
