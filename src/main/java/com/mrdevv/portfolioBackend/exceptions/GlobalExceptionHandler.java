package com.mrdevv.portfolioBackend.exceptions;


import com.mrdevv.portfolioBackend.handler.ResponseError;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import com.mrdevv.portfolioBackend.utils.FormateadorFechas;
import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;
import com.mrdevv.portfolioBackend.utils.constants.Roles;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        Exception.class,
        ObjectNotFoundException.class,
        HttpMessageNotReadableException.class,
        BadCredentialsException.class,
        ObjectReplicatedException.class,
        ConstraintViolationException.class,
        MethodArgumentNotValidException.class
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
        }else if (exception instanceof ObjectReplicatedException objectReplicatedException){
            Integer code = HttpStatus.CONFLICT.value();
            ResponseError responseError = new ResponseError(
                    "Failed",
                    code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    objectReplicatedException.getMessageFront(),
                    objectReplicatedException.getMessageBack(),
                    localDateTime,
                    null
            );
            return ResponseEntity.status(code).body(responseError);
        } else if (exception instanceof HttpMessageNotReadableException){
            Integer code = HttpStatus.BAD_REQUEST.value();
            String messageFront = null;
            String messageBack = null;

            String path = request.getRequestURI();
            if (path.contains("usuarios")) {
                messageFront = ErrorMessage.INVALID_VALUE_ROL_ENUM_FRONT.getMessage() + Arrays.stream(Roles.values()).map(Roles::getRol).toList();
                messageBack = ErrorMessage.INVALID_VALUE_ROL_ENUM_BACKEND.getMessage();
            }

            if (path.contains("tecnologias")) {
                messageFront = ErrorMessage.INVALID_VALUE_NIVEL_TEC_ENUM_FRONT.getMessage() + Arrays.stream(NivelTecnologia.values()).map(NivelTecnologia::getNivel).toList();
                messageBack = ErrorMessage.INVALID_VALUE_NIVEL_TEC_ENUM_BACKEND.getMessage();
            }

            ResponseError responseError = new ResponseError(
                    "Failed",
                    code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    messageFront,
                    messageBack,
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
        }else if (exception instanceof ConstraintViolationException constraintViolationException){
            Integer code = HttpStatus.BAD_REQUEST.value();
            List<String> details = constraintViolationException.getConstraintViolations()
                    .stream()
                    .map(constraintViolation -> {
                        String field = constraintViolation.getPropertyPath().toString();
                        String paramName = field.contains(".") ? field.substring(field.lastIndexOf(".") + 1) : field;
                        return paramName + ": " + constraintViolation.getMessage();
                    })
                    .toList();

            ResponseError responseError = new ResponseError(
                    "Failed", code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    "Parámetro inválido",
                    constraintViolationException.getMessage(),
                    localDateTime, details
            );
            return ResponseEntity.status(code).body(responseError);
        }else if (exception instanceof MethodArgumentNotValidException handlerException){
            Integer code = HttpStatus.BAD_REQUEST.value();

            List<String> details = handlerException.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ResponseError responseError = new ResponseError(
                    "Failed", code,
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    "Parámetros inválidos",
                    "El o los parámetros del BODY son inválidos",
                    localDateTime,
                    details
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
