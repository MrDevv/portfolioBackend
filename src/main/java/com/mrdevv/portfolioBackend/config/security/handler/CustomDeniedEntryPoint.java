package com.mrdevv.portfolioBackend.config.security.handler;

import com.mrdevv.portfolioBackend.handler.ResponseError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class CustomDeniedEntryPoint implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        int httpStatus = HttpStatus.FORBIDDEN.value();
        String messageBack = "El acceso al recurso solicitado no está permitido.";
        String messageFront = "No tiene los permisos suficientes para realizar esa operación.";

        System.out.println(accessDeniedException.getMessage());

        String error = (String) request.getAttribute("auth_error");

        if (error != null){
            if (error.equalsIgnoreCase("EMAIL_NOT_VERIFIED")){
                messageBack = "El email del usuario no ha sido verificado.";
                messageFront = "El email del usuario no ha sido verificado, por favor verifique su email para poder iniciar sesión.";
            }else if (error.equalsIgnoreCase("ACCOUNT_INACTIVE")){
                messageBack = "La cuenta del usuario está inactiva.";
                messageFront = "La cuenta del usuario está inactiva, por favor contacte al soporte para más información.";
            }
        }

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                messageFront,
                messageBack,
                localDateTime,
                null
        );

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(httpStatus);

        ObjectMapper objectMapper = new ObjectMapper();
        String apiErrorAsJson = objectMapper.writeValueAsString(responseError);
        response.getWriter().write(apiErrorAsJson);
    }
}
