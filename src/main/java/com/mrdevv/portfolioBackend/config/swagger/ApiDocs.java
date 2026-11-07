package com.mrdevv.portfolioBackend.config.swagger;

public final class ApiDocs {

    private ApiDocs() {
    }

    public static final String BAD_REQUEST = "Solicitud inválida. Los datos proporcionados no cumplen con las validaciones requeridas.";
    public static final String UNAUTHORIZED = "No autorizado. El usuario no está autenticado o el token JWT es inválido o ha expirado.";
    public static final String UNAUTHORIZED_API_KEY = "No autorizado. La API key no fue enviada o es inválida.";
    public static final String FORBIDDEN_API_KEY = "Acceso denegado. La cuenta no está activa, el correo no ha sido verificado o el origen de la petición no está permitido.";
    public static final String FORBIDDEN_ADMIN = "Acceso denegado. El usuario no tiene el rol de administrador.";
    public static final String CONFLICT = "Conflicto. Ya existe un recurso con los mismos datos proporcionados.";
    public static final String INTERNAL_ERROR = "Error interno del servidor.";

    public static final String PARAM_PAGE = "Número de página (inicia en 0).";
    public static final String PARAM_SIZE = "Cantidad de elementos por página.";
}
