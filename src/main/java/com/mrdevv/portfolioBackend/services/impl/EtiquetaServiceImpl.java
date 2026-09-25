package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;
import com.mrdevv.portfolioBackend.models.Etiqueta;
import com.mrdevv.portfolioBackend.repositories.EtiquetaRepository;
import com.mrdevv.portfolioBackend.services.IEtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtiquetaServiceImpl implements IEtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    @Override
    public List<ResponseEtiquetaDTO> obtenerEtiquetas() {
        return List.of();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Etiqueta> obtenerEtiquetasPorUUIDs(List<String> etiquetaUUIDs) {
        return etiquetaRepository.findAllByEtiquetaUUIDIn(etiquetaUUIDs);
    }
}
