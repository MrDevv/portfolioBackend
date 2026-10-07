package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me/proyectos")
public class MeProyectoController {

    private final IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity obtenerProyectosProfesionalAutenticado(@RequestParam(name = "titulo", required = false) String titulo,
                                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable proyectos = proyectoService.obtenerProyectosProfesionalAutenticado(titulo, pageable);
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los proyectos correctamente", proyectos);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity obtenerProyectoPorUUID(@PathVariable(name = "uuid") String proyectoUUID){
        ResponseProyectoDTO proyecto = proyectoService.obtenerProyectoPorUUID(proyectoUUID);
        return ResponseHandler.ok(TipoResponse.GET, "Se obtuvo el proyecto correctamente", proyecto);
    }

    @PostMapping
    public ResponseEntity crearProyecto(@Valid @RequestBody CreateProyectoDTO proyectoDTO){
        ResponseProyectoDTO proyectoCreado = proyectoService.crearProyecto(proyectoDTO);
        return ResponseHandler.ok(TipoResponse.CREATE, "Se creó el proyecto correctamente", proyectoCreado);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity actualizarProyecto(@PathVariable(name = "uuid") String proyectoUUID, @Valid @RequestBody UpdateProyectoDTO proyectoDTO){
        ResponseProyectoDTO proyectoActualizado = proyectoService.actualizarProyecto(proyectoUUID, proyectoDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "Se actualizó el proyecto correctamente", proyectoActualizado);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity eliminarProyecto(@PathVariable(name = "uuid") String proyectoUUID){
        proyectoService.eliminarProyecto(proyectoUUID);
        return ResponseHandler.ok(TipoResponse.DELETE, "Se eliminó el proyecto correctamente", null);
    }
}
