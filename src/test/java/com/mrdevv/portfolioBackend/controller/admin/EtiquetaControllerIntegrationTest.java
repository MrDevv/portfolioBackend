package com.mrdevv.portfolioBackend.controller.admin;

import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import com.mrdevv.portfolioBackend.support.DatabaseCleaner;
import com.mrdevv.portfolioBackend.support.fixture.ProfesionalFixture;
import com.mrdevv.portfolioBackend.support.fixture.UsuarioFixture;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import javax.management.ConstructorParameters;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class EtiquetaControllerIntegrationTest {

    private final ProfesionalFixture profesionalFixture;
    private final UsuarioFixture usuarioFixture;
    private final MockMvc mockMvc;
    private final DatabaseCleaner databaseCleaner;
    private final JwtService jwtService;

    private Profesional profesional;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        databaseCleaner.clean();
        this.profesional = profesionalFixture.crearProfesional("test", "lastname");
        this.usuario = usuarioFixture.crearUsuario("test@gmail.com", "test1234", null, "admin", profesional);
    }

    @Test
    public void obtenerEtiquetasExitosamente() throws Exception {
        mockMvc.perform(get("/admin/etiquetas")
                        .header("Authorization", "Bearer " + jwtService.generarToken(usuario))
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.content").isArray())
                .andExpect(jsonPath("$.data.pageableData.numberOfElements").value(10));
    }

}
