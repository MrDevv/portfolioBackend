package com.mrdevv.portfolioBackend.controllers.admin;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IEtiquetaService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/etiquetas")
@RequiredArgsConstructor
public class EtiquetaController {

    private final IEtiquetaService etiquetaService;

    @GetMapping
    public ResponseEntity obtenerEtiquetas(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", required = false, defaultValue = "40") Integer size,
                                           @RequestParam(name = "nombre", required = false) String nombre) {
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable etiquetas = etiquetaService.obtenerEtiquetas(pageable, nombre);
        return ResponseHandler.ok(TipoResponse.GETALL, "Se obtuvieron las etiquetas correctamente", etiquetas);
    }
}
