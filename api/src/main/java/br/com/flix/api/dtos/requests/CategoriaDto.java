package br.com.flix.api.dtos.requests;

import br.com.flix.api.model.enums.Cor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoriaDto(

        @NotBlank
        String titulo,

        @NotNull
        Cor cor) {
}
