package com.mrdevv.portfolioBackend.utils.constants;

public enum ErrorMessage {

    NOT_FOUND_DESARROLLADOR_FRONT("No se encontró el desarrollador con id '%s'"),
    NOT_FOUND_DESARROLLADOR_BACKEND("No se encontró el OBJECT 'DESARROLLADOR' con ID '%s' en la base de datos."),
    INVALID_VALUE_ROL_ENUM_FRONT("El rol ingresado no es válido, solo se permite el rol 'administrador' o 'usuario'"),
    INVALID_VALUE_ROL_ENUM_BACKEND("El rol ingresado no forma parte del sistema"),
    NOT_FOUND_ROL_FRONT("No se encontró el rol con descripción '%s'"),
    NOT_FOUND_ROL_BACKEND("No se encontró el OBJECT 'ROL' con DESCRIPCION '%s' en la base de datos."),
    NOT_FOUND_USUARIO_FRONT("No se encontró el usuario con id '%s'"),
    NOT_FOUND_USUARIO_BACKEND("No se encontró el OBJECT 'USUARIO' con ID '%s' en la base de datos.");


    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(Object... args){
        return String.format(this.message, args);
    }


}
