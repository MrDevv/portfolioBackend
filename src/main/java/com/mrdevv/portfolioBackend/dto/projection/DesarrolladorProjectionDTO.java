package com.mrdevv.portfolioBackend.dto.projection;

import java.util.UUID;

public interface DesarrolladorProjectionDTO {
    UUID getDesarrolladorUUID();
    String getNombres();
    String getApellidos();
    String getCorreoContacto();
    String getGithubUrl();
    String getLinkedinUrl();
    String getCvUrl();
    String getLogoUrl();
    String getPrefijoTelefono();
    String getTelefono();
    String getBiografia();
    String getPuesto();
}
