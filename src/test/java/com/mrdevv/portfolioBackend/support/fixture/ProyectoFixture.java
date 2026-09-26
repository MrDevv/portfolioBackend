package com.mrdevv.portfolioBackend.support.fixture;

import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Proyecto;
import com.mrdevv.portfolioBackend.models.TipoProyecto;
import com.mrdevv.portfolioBackend.repositories.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProyectoFixture {

    private final ProyectoRepository proyectoRepository;

    public Proyecto crearProyecto(String titulo, String descripcion, Experiencia experiencia, TipoProyecto tipoProyecto) {
        Proyecto proyecto = Proyecto.builder()
                .titulo(titulo)
                .descripcion(descripcion)
                .experiencia(experiencia)
                .tipoProyecto(tipoProyecto)
                .build();
        return proyectoRepository.save(proyecto);
    }

}
