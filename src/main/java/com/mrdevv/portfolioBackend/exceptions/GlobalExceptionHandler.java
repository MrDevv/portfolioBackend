package com.mrdevv.portfolioBackend.exceptions;


import com.mrdevv.portfolioBackend.handler.ResponseError;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import com.mrdevv.portfolioBackend.utils.FormateadorFechas;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        Exception.class,
        ObjectNotFoundException.class,
        HttpMessageNotReadableException.class,
    })
    public ResponseEntity<Object> handlerAllException(Exception exception, HttpServletRequest request, HttpServletResponse response){
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        String fecha = FormateadorFechas.formatearDiaMesAnioHorayMinutos(localDateTime);

        if (exception instanceof ObjectNotFoundException objectNotFoundException){
            Integer code = HttpStatus.NOT_FOUND.value();
            ResponseError responseError = new ResponseError(
                    "Failed",
                    code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    objectNotFoundException.getMessageFront(),
                    objectNotFoundException.getMessageBack(),
                    localDateTime,
                    null
            );
            return ResponseEntity.status(code).body(responseError);
        }else if (exception instanceof HttpMessageNotReadableException){
            Integer code = HttpStatus.BAD_REQUEST.value();
            ResponseError responseError = new ResponseError(
                    "Failed",
                    code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    ErrorMessage.INVALID_VALUE_ROL_ENUM_FRONT.getMessage(),
                    ErrorMessage.INVALID_VALUE_ROL_ENUM_BACKEND.getMessage(),
                    localDateTime,
                    null
            );
            return ResponseEntity.status(code).body(responseError);
        }else if(exception instanceof BadCredentialsException){
            Integer code = HttpStatus.UNAUTHORIZED.value();
            ResponseError responseError = new ResponseError(
                    "Failed",
                    code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    ErrorMessage.BAD_CREDENTIALS_LOGIN_FRONT.getMessage(),
                    ErrorMessage.BAD_CREDENTIALS_LOGIN_BACKEND.getMessage(),
                    localDateTime,
                    null
            );
            return ResponseEntity.status(code).body(responseError);
        }

        Integer httStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ResponseError responseError = new ResponseError(
                "Failed",
                httStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Lo sentimos ocurrió un error en nuestro servidor. Por favor intentelo mas tarde",
                exception.getMessage(),
                localDateTime,
                null
        );
        return ResponseEntity.status(httStatus).body(responseError);
    }

}
