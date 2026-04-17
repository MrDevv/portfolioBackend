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

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "No tiene los permisos suficientes para realizar esa operación.",
                "El ROL USER no puede realizar esta operación.",
                localDateTime,
                null
        );

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(httpStatus);

        ObjectMapper objectMapper = new ObjectMapper();
        String apiErrorAsJson = objectMapper.writeValueAsString(responseError);
        response.getWriter().write(apiErrorAsJson);
    }
}
