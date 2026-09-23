package com.mrdevv.portfolioBackend.controller.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrdevv.portfolioBackend.config.TestContainerConfiguration;
import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
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
import tools.jackson.databind.json.JsonMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestContainerConfiguration.class)
@ActiveProfiles("test")
public class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonMapper objectMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {

        usuarioRepository.deleteAll();
        profesionalRepository.deleteAll();
        rolRepository.deleteAll();

        Rol rol = Rol.builder()
                .descripcion("admin")
                .build();

        rol = rolRepository.save(rol);

        Profesional profesional = Profesional.builder()
                .nombres("Usuario")
                .apellidos("Integracion")
                .build();

        profesional = profesionalRepository.save(profesional);

        Usuario usuario = Usuario.builder()
                .email("miguelvegap10@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .rol(rol)
                .profesional(profesional)
                .build();

        usuarioRepository.save(usuario);
    }

    @Test
    void deberiaAutenticarUsuarioConCredencialesValidas() throws Exception {

        AuthDTO authDTO = new AuthDTO("miguelvegap10@gmail.com", "admin");


        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authDTO)))
                .andExpect(status().isOk());
    }
}
