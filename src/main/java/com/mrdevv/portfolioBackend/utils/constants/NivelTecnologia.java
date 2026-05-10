package com.mrdevv.portfolioBackend.utils.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NivelTecnologia {
    BÁSICO("básico"),
    INTERMEDIO("intermedio"),
    AVANZADO("avanzado");

    String nivel;

    NivelTecnologia(String nivel) {
        this.nivel = nivel;
    }

    @JsonValue
    public String getNivel(){
        return this.nivel;
    }
}
