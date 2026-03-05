package com.mrdevv.portfolioBackend.utils.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Roles {
    ADMINISTRADOR("administrador"),
    USUARIO("usuario");

    private String rol;

    Roles(String rol){
        this.rol = rol;
    }

    @JsonValue
    public String getRol(){
        return this.rol;
    }
}
