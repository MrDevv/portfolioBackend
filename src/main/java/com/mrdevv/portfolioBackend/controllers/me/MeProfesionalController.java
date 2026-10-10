package com.mrdevv.portfolioBackend.controllers.me;

import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.handler.ResponseHandler;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import com.mrdevv.portfolioBackend.utils.constants.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("me")
public class MeProfesionalController {

    private final IProfesionalService profesionalService;
    private final IUsuarioService usuarioService;

    @GetMapping("/datos")
    public ResponseEntity<Object> obtenerDatosProfesionales(){
        ResponseProfesionalDTO profesionalDTO = profesionalService.obtenerDatosProfesionalAutenticado();
        return ResponseHandler.ok(TipoResponse.GETALL, "se obtuvieron los datos profesionales correctamente", profesionalDTO);
    }

    @PutMapping("/datos")
    public ResponseEntity<Object> actualizarDatosProfesionales(@RequestBody UpdateProfesionalDTO updateProfesionalDTO){
        ResponseProfesionalDTO profesionalDTO = profesionalService.actualizarProfesionalAutenticado(updateProfesionalDTO);
        return ResponseHandler.ok(TipoResponse.UPDATE, "se actualizaron los datos profesionales correctamente", profesionalDTO);
    }

    @PostMapping("/api-key")
    public ResponseEntity<Object> generarApiKey(){
        ResponseApiKeyUsuario apiKey = usuarioService.generarApiKey();
        return ResponseHandler.ok(TipoResponse.CREATE, "se generó la API key correctamente", apiKey);
    }

    @DeleteMapping("/api-key")
    public ResponseEntity<Object> eliminarApiKey(){
        usuarioService.revocarApiKey();
        return ResponseHandler.ok(TipoResponse.DELETE, "se eliminó la API key correctamente", null);
    }
}
