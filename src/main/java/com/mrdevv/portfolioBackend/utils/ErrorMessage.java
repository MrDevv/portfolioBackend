package com.mrdevv.portfolioBackend.utils;

public enum ErrorMessage {

    NOT_FOUND_DESARROLLADOR_FRONT("No se encontró el desarrollador con id '%s'"),
    NOT_FOUND_DESARROLLADOR_BACKEND("No se encontró el OBJECT 'DESARROLLADOR' con ID '%s' en la base de datos.");


    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(Object... args){
        return String.format(this.message, args);
    }


}
