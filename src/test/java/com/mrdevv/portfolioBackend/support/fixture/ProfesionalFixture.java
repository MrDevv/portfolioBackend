package com.mrdevv.portfolioBackend.support.fixture;

import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfesionalFixture {
    private final ProfesionalRepository profesionalRepository;

    public Profesional crearProfesional(String nombres, String apellidos, String correoContacto, String githubUrl, String linkedinUrl, String cvUrl, String logoUrl, String prefijoTelefono, String numeroTelefono, String biografia, String puesto) {
        Profesional profesional = Profesional.builder()
                .nombres(nombres)
                .apellidos(apellidos)
                .correoContacto(correoContacto)
                .githubUrl(githubUrl)
                .linkedinUrl(linkedinUrl)
                .cvUrl(cvUrl)
                .logoUrl(logoUrl)
                .prefijoTelefono(prefijoTelefono)
                .telefono(numeroTelefono)
                .biografia(biografia)
                .puesto(puesto)
                .build();
        return profesionalRepository.save(profesional);
    }

    public Profesional crearProfesional(String nombres, String apellidos) {
        Profesional profesional = Profesional.builder()
                .nombres(nombres)
                .apellidos(apellidos)
                .build();
        return profesionalRepository.save(profesional);
    }
}
