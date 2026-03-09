package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.models.Proyecto;
import com.mrdevv.portfolioBackend.repositories.ProyectoRepository;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProyectoServiceImpl implements IProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Proyecto> obtenerProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        proyectos.forEach(proyecto -> {
            System.out.println(proyecto);
        });
        return proyectos;
    }
}
