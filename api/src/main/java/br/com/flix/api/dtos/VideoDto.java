package br.com.flix.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record VideoDto(

        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotBlank
        String url) {

}
