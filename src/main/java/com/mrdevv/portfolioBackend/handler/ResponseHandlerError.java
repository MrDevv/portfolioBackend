package com.mrdevv.portfolioBackend.handler;

import com.mrdevv.portfolioBackend.utils.TipoResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ResponseHandlerError {
    public static ResponseEntity<Object> error(Integer status, HttpServletRequest request, String messageFront, String messageBack, String date){
        HashMap<String, Object> response = new LinkedHashMap<>();

        response.put("status", "Failed");
        response.put("url", request.getRequestURL().toString());
        response.put("method", request.getMethod());
        response.put("message", messageFront);
        response.put("backend_message", messageBack);
        response.put("date", date);

        return ResponseEntity.status(status).body(response);
    }
}
