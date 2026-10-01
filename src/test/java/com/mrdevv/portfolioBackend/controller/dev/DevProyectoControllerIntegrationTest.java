package com.mrdevv.portfolioBackend.controller.dev;

import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.models.*;
import com.mrdevv.portfolioBackend.repositories.*;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import com.mrdevv.portfolioBackend.support.DatabaseCleaner;
import com.mrdevv.portfolioBackend.support.fixture.ExperienciaFixture;
import com.mrdevv.portfolioBackend.support.fixture.ProfesionalFixture;
import com.mrdevv.portfolioBackend.support.fixture.ProyectoFixture;
import com.mrdevv.portfolioBackend.support.fixture.UsuarioFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
public class DevProyectoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TipoProyectoRepository tipoProyectoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    DatabaseCleaner databaseCleaner;

    @Autowired
    UsuarioFixture usuarioFixture;

    @Autowired
    ProfesionalFixture profesionalFixture;

    @Autowired
    ExperienciaFixture experienciaFixture;

    @Autowired
    JwtService jwtService;

    @Autowired
    private ProyectoFixture proyectoFixture;

    private Profesional profesional;
    private Usuario usuario;
    private Experiencia experiencia;
    private String token;

    @BeforeEach
    void setUp() {
        databaseCleaner.clean();
        LocalDate fechaInicio = LocalDate.of(2024, 3, 1);
        profesional = profesionalFixture.crearProfesional("Test", "User");
        usuario = usuarioFixture.crearUsuario("testuser@gmail.com", "password", null, "admin", profesional);
        experiencia = experienciaFixture.crearExperiencia("Experiencia de prueba", "Descripción de la experiencia de prueba", fechaInicio, null, "proyecto persona", "fullstack", profesional);
        token = jwtService.generarToken(usuario);
    }

    @Test
    void crearNuevoProyectoCorrectamente() throws Exception {
        TipoProyecto tipoProyecto = tipoProyectoRepository.obtenerTipoProyectoPorUUID("d6e5f3d6-18c4-4184-b813-0415d265e3e2").orElseThrow();
        String[] etiquetas = {"cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b", "b051f5dc-07a9-4fd1-a56d-92294092be57"};

        CreateProyectoDTO proyectoDTO = new CreateProyectoDTO(
                "Proyecto de prueba",
                "Descripción del proyecto de prueba",
                null,
                null,
                null,
                experiencia.getExperienciaUUID(),
                tipoProyecto.getTipoProyectoUUID(),
                etiquetas
        );

        mockMvc.perform(post("/me/proyectos")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(proyectoDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.titulo").value("Proyecto de prueba"))
                .andExpect(jsonPath("$.data.descripcion").value("Descripción del proyecto de prueba"))
                .andExpect(jsonPath("$.data.experiencia.experiencia_uuid").value(experiencia.getExperienciaUUID()))
                .andExpect(jsonPath("$.data.tipo_proyecto.tipo_proyecto_uuid").value(tipoProyecto.getTipoProyectoUUID()))
                .andExpect(jsonPath("$.data.etiquetas[*].etiqueta_uuid")
                        .value(containsInAnyOrder(
                                "cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b",
                                "b051f5dc-07a9-4fd1-a56d-92294092be57")
                        )
                );
    }

    @Test
    void crearNuevoProyectoConCamposIncompletos() throws Exception {
        String[] etiquetas = {"cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b", "b051f5dc-07a9-4fd1-a56d-92294092be57"};

        CreateProyectoDTO proyectoDTO = new CreateProyectoDTO(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                etiquetas
        );

        mockMvc.perform(post("/me/proyectos")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(proyectoDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("Failed"))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.method").value("POST"))
                .andExpect(jsonPath("$.message").value("Parámetros inválidos"))
                .andExpect(jsonPath("$.details[*]").value(
                        containsInAnyOrder(
                        "El tipo de proyecto es obligatorio",
                        "El titulo es obligatorio",
                        "La experiencia es obligatoria",
                        "La descripcion es obligatoria"
                        )
                    )
                );
    }

    @Test
    void crearNuevoProyectoConTituloYaExistenteEnLaExperiencia() throws Exception {
        TipoProyecto tipoProyecto = tipoProyectoRepository.obtenerTipoProyectoPorUUID("d6e5f3d6-18c4-4184-b813-0415d265e3e2").orElseThrow();
        String[] etiquetas = {"cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b", "b051f5dc-07a9-4fd1-a56d-92294092be57"};

        proyectoFixture.crearProyecto("Proyecto de prueba", "Descripción del prueba 2", experiencia, tipoProyecto);

        CreateProyectoDTO proyectoDTO = new CreateProyectoDTO(
                "Proyecto de prueba",
                "Descripción del proyecto de prueba",
                null,
                null,
                null,
                experiencia.getExperienciaUUID(),
                tipoProyecto.getTipoProyectoUUID(),
                etiquetas
        );

        mockMvc.perform(post("/me/proyectos")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(proyectoDTO)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.code").value(409))
                .andExpect(jsonPath("$.method").value("POST"))
                .andExpect(jsonPath("$.message").value("El proyecto con el título 'Proyecto de prueba' ya está registrado para esta experiencia"));
    }

    @Test
    void crearNuevoProyectoConTokenInvalido() throws Exception {
        TipoProyecto tipoProyecto = tipoProyectoRepository.obtenerTipoProyectoPorUUID("d6e5f3d6-18c4-4184-b813-0415d265e3e2").orElseThrow();
        String[] etiquetas = {"cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b", "b051f5dc-07a9-4fd1-a56d-92294092be57"};

        proyectoFixture.crearProyecto("Proyecto de prueba", "Descripción del prueba 2", experiencia, tipoProyecto);

        CreateProyectoDTO proyectoDTO = new CreateProyectoDTO(
                "Proyecto de prueba",
                "Descripción del proyecto de prueba",
                null,
                null,
                null,
                experiencia.getExperienciaUUID(),
                tipoProyecto.getTipoProyectoUUID(),
                etiquetas
        );

        mockMvc.perform(post("/me/proyectos")
                        .header("Authorization", "Bearer " + "token_invalido")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(proyectoDTO)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.code").value(401))
                .andExpect(jsonPath("$.method").value("POST"))
                .andExpect(jsonPath("$.message").value("El token proporcionado no es válido."));
    }

    @Test
    void crearNuevoProyectoConTokenNulo() throws Exception {
        TipoProyecto tipoProyecto = tipoProyectoRepository.obtenerTipoProyectoPorUUID("d6e5f3d6-18c4-4184-b813-0415d265e3e2").orElseThrow();
        String[] etiquetas = {"cad5bfe9-12e9-4c1a-b926-c7d1c6dcdf9b", "b051f5dc-07a9-4fd1-a56d-92294092be57"};

        proyectoFixture.crearProyecto("Proyecto de prueba", "Descripción del prueba 2", experiencia, tipoProyecto);

        CreateProyectoDTO proyectoDTO = new CreateProyectoDTO(
                "Proyecto de prueba",
                "Descripción del proyecto de prueba",
                null,
                null,
                null,
                experiencia.getExperienciaUUID(),
                tipoProyecto.getTipoProyectoUUID(),
                etiquetas
        );

        mockMvc.perform(post("/me/proyectos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(proyectoDTO)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.code").value(401))
                .andExpect(jsonPath("$.method").value("POST"))
                .andExpect(jsonPath("$.message").value("No está logeado o su sesión no es válida, por favor inicie sesión."));
    }
}
