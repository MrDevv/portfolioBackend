package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;
import com.mrdevv.portfolioBackend.mappers.EtiquetaMapper;
import com.mrdevv.portfolioBackend.models.Etiqueta;
import com.mrdevv.portfolioBackend.repositories.EtiquetaRepository;
import com.mrdevv.portfolioBackend.services.IEtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtiquetaServiceImpl implements IEtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerEtiquetas(Pageable page, String nombre) {
        String nombreFilter = (nombre != null && !nombre.isEmpty()) ? nombre : "";
        Page<Etiqueta> etiquetas = etiquetaRepository.obtenerEtiquetas(page, nombreFilter);
        return EtiquetaMapper.toEtiquetaListDTO(etiquetas);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Etiqueta> obtenerEtiquetasPorUUIDs(List<String> etiquetaUUIDs) {
        return etiquetaRepository.findAllByEtiquetaUUIDIn(etiquetaUUIDs);
    }
}
