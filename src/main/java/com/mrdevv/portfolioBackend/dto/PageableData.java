package com.mrdevv.portfolioBackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información de paginación")
public record PageableData(
        @Schema(description = "Número de la página actual (inicia en 0)", example = "0")
        Integer numberPage,
        @Schema(description = "Indica si es la última página", example = "false")
        Boolean lastPage,
        @Schema(description = "Indica si es la primera página", example = "true")
        Boolean firstPage,
        @Schema(description = "Total de páginas", example = "5")
        Integer totalPages,
        @Schema(description = "Total de elementos", example = "42")
        Long totalElements,
        @Schema(description = "Cantidad de elementos en la página actual", example = "10")
        Integer numberOfElements,
        @Schema(description = "Posición del primer elemento de la página", example = "0")
        Long offset
) {
}
