package com.movieflix.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        @Schema(type = "long", description = "Codigo do filme")
        Long id,
        @Schema(type = "string", description = "Titulo do filme")
        String title,
        @Schema(type = "string", description = "Descrição do filme")
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(type = "date", description = "Data de lançamento do filme")
        LocalDate releaseDate,
        @Schema(type = "double", description = "Nota do filme")
        double rating,
        @Schema(type = "array", description = "Lista de codigos de categoria")
        List<CategoryResponse> categories,
        @Schema(type = "array", description = "Lista de codigos de serviço de streaming")
        List<StreamingResponse> stremings
) {
}
