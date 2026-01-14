package com.movieflix.controller.response;

import com.movieflix.controller.request.MovieRequest;
import com.movieflix.entity.Movie;
import com.movieflix.mapper.MovieMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Movie", description = "Recurso resposavel pelo gerenciamento dos filmes.")
public interface MovieController {
    @Operation(summary = "Salvar filme", description = "Método resposavel por realizar o salvemento de um novo filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);


    @Operation(summary = "Buscar filmes", description = "Método resposavel por retornar todos os filmes cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findAll();

    @Operation(summary = "Buscar filme por id", description = "Método resposavel por buscar filme por id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
   ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Alterar filme ", description = "Método resposavel por alterar dados filme do id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
   ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar filme por categoria", description = "Método resposavel por buscar filmes por categoria.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filmes encontrados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @ApiResponse(responseCode = "404", description = "Filmes não encontrados", content = @Content())
   ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category);

    @Operation(summary = "Deletar filme por id ", description = "Método resposavel por deletar filmes por id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
   ResponseEntity<Void> delete(@PathVariable Long id);
}
