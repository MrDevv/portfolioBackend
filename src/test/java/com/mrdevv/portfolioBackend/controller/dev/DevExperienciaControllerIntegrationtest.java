package com.mrdevv.portfolioBackend.controller.dev;

import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import com.mrdevv.portfolioBackend.support.fixture.ExperienciaFixture;
import com.mrdevv.portfolioBackend.support.fixture.ProfesionalFixture;
import com.mrdevv.portfolioBackend.support.fixture.UsuarioFixture;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class DevExperienciaControllerIntegrationtest {

    private final MockMvc mockMvc;
    private final ProfesionalFixture profesionalFixture;
    private final UsuarioFixture usuarioFixture;
    private final ExperienciaFixture experienciaFixture;
    private final JwtService jwtService;

    private Profesional profesional;
    private Usuario usuario;
    private Experiencia experiencia;

    @BeforeEach
    void setUp() {
        LocalDate fechaInicio = LocalDate.of(2026, 4, 20);
        this.profesional = profesionalFixture.crearProfesional("firstname test", "lastname test");
        this.usuario = usuarioFixture.crearUsuario("testuser@gmail.com", "testpassword", null, "admin", profesional);
        this.experiencia = this.experienciaFixture.crearExperiencia("Experiencia 1", "descripcion", fechaInicio, null, "nombre empresa", "backend developer", profesional);
    }

    @Test
    public void obtenerExperienciasSimplesDelProfesionalAutenticadoCorrectamente() throws Exception {

        mockMvc.perform(get("/me/experiencias/simple")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + jwtService.generarToken(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());

    }

}
