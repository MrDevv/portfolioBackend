package com.mrdevv.portfolioBackend.controller.dev;

import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import com.mrdevv.portfolioBackend.repositories.RolRepository;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
public class DevProfesionalControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAllInBatch();
        profesionalRepository.deleteAllInBatch();
        rolRepository.deleteAllInBatch();

        Rol rol = Rol.builder()
                .descripcion("admin")
                .build();

        rol = rolRepository.save(rol);

        Profesional profesional = Profesional.builder()
                .nombres("Miguel Angel")
                .apellidos("Vega Perez")
                .biografia("Desarrollador Full Stack con experiencia en Java y Spring Boot, apasionado por la creación de aplicaciones web escalables y eficientes. Con habilidades en front-end y back-end, me especializo en el desarrollo de soluciones innovadoras que mejoran la experiencia del usuario y optimizan los procesos empresariales.")
                .build();

        profesional = profesionalRepository.save(profesional);

        Usuario usuario = Usuario.builder()
                .email("miguelvega@gmail.com")
                .password(passwordEncoder.encode("password123"))
                .rol(rol)
                .apiKey("your_api_key_here")
                .profesional(profesional)
                .build();

        usuarioRepository.save(usuario);
    }

    @Test
    void deberiaObtenerLosDatosDelProfesional() throws Exception {

        String response = """
                {
                    "nombres": "Miguel Angel",
                    "apellidos": "Vega Perez",
                    "correo_contacto": "miguelvega@gmail.com"
                }
                """;

        mockMvc.perform(get("/dev/me/datos")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer your_api_key_here")
                .content(objectMapper.writeValueAsString(response))
                ).andExpect(status().isOk());
    }

}
