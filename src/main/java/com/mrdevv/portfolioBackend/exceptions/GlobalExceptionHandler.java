package com.mrdevv.portfolioBackend.exceptions;


import com.mrdevv.portfolioBackend.handler.ResponseHandlerError;
import com.mrdevv.portfolioBackend.utils.FormateadorFechas;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        ObjectNotFoundException.class,
        RuntimeException.class
    })
    public ResponseEntity<Object> handlerAllException(Exception exception, HttpServletRequest request, HttpServletResponse response){
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        String fecha = FormateadorFechas.formatearDiaMesAnioHorayMinutos(localDateTime);

        if (exception instanceof ObjectNotFoundException objectNotFoundException){
            Integer code = HttpStatus.NOT_FOUND.value();
            return ResponseHandlerError.error(code, request, objectNotFoundException.getMessageFront(), objectNotFoundException.getMessageBack(), fecha);
        }

        RuntimeException runtimeException = (RuntimeException) exception;
        return ResponseHandlerError.error(500, request, "Ocurrio un error en el servidor", runtimeException.getMessage(), fecha);

    }

}
