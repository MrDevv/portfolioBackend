package com.mrdevv.portfolioBackend.utils.constants;

public enum ErrorMessage {

    NOT_FOUND_PROFESIONAL_FRONT("No se encontró el profesional"),
    NOT_FOUND_PROFESIONAL_BACKEND("No se encontró el OBJECT 'PROFESIONAL' en la base de datos."),
    INVALID_VALUE_ROL_ENUM_FRONT("El rol ingresado no es válido, solo se permite los roles de: "),
    INVALID_VALUE_ROL_ENUM_BACKEND("El rol ingresado no forma parte del sistema"),
    INVALID_VALUE_NIVEL_TEC_ENUM_FRONT("El nivel ingresado no es válido, solo se permiten los niveles: "),
    INVALID_VALUE_NIVEL_TEC_ENUM_BACKEND("El nivel ingresado no forma parte del sistema"),
    NOT_FOUND_ROL_FRONT("No se encontró el rol con descripción '%s'"),
    NOT_FOUND_ROL_BACKEND("No se encontró el OBJECT 'ROL' con DESCRIPCION '%s' en la base de datos."),
    NOT_FOUND_USUARIO_FRONT("No se encontró el usuario con id '%s'"),
    NOT_FOUND_USUARIO_BACKEND("No se encontró el OBJECT 'USUARIO' con ID '%s' en la base de datos."),
    NOT_FOUND_USUARIO_BY_EMAIL_FRONT("No se encontró el usuario con email '%s'"),
    NOT_FOUND_USUARIO_BY_EMAIL_BACKEND("No se encontró el OBJECT 'USUARIO' con EMAIL '%s' en la base de datos."),
    NOT_FOUND_TIPO_PROYECTO_FRONT("No se encontró el tipo proyecto con id '%s'"),
    NOT_FOUND_TIPO_PROYECTO_BACKEND("No se encontró el OBJECT 'TIPOPROYECTO' con ID '%s' en la base de datos."),
    NOT_FOUND_TECNOLOGIA_FRONT("No se encontró la tecnología con uuid '%s'"),
    NOT_FOUND_TECNOLOGIA_BACKEND("No se encontró el OBJECT 'TECNOLOGIA' con UUID '%s' en la base de datos."),
    REPLICATE_OBJECT_TECNOLOGIA_PROFESIONAL_FRONT("La tecnología '%s' ya se encuentra registrada para el profesional"),
    REPLICATE_OBJECT_TECNOLOGIA_PROFESIONAL_BACKEND("El OBJECT 'TECNOLOGIA' con UUID '%s' ya se encuentra registrada para el OBJECT 'PROFESIONAL'."),
    BAD_CREDENTIALS_LOGIN_FRONT("Usuario o contraseña incorrectos, revise sus datos"),
    BAD_CREDENTIALS_LOGIN_BACKEND("Credenciales incorrectas");


    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(Object... args){
        return String.format(this.message, args);
    }


}
