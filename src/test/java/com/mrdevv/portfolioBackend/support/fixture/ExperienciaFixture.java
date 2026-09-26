package com.mrdevv.portfolioBackend.support.fixture;

import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.repositories.ExperienciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ExperienciaFixture {

    private final ExperienciaRepository experienciaRepository;

    public Experiencia crearExperiencia(String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String nombreEmpresa, String puesto, Profesional profesional) {
        Experiencia experiencia = Experiencia.builder()
                .titulo(titulo)
                .descripcion(descripcion)
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .nombreEmpresa(nombreEmpresa)
                .puesto(puesto)
                .profesional(profesional)
                .build();
        return experienciaRepository.save(experiencia);
    }


}
