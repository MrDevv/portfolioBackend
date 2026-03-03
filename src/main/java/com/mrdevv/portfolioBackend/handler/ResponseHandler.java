package com.mrdevv.portfolioBackend.handler;

import com.mrdevv.portfolioBackend.utils.TipoResponse;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ResponseHandler {

    public static ResponseEntity<Object> ok(TipoResponse tipoResponse, String mensaje, Object data){
        HashMap<String, Object> response = new LinkedHashMap<>();

        response.put("status", "OK");
        response.put("message", mensaje);
        response.put("data", data);

        return ResponseEntity.status(tipoResponse.getStatus()).body(response);
    }

}
