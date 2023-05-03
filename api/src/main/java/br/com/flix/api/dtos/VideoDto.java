package br.com.flix.api.dtos;

import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.Video;
import br.com.flix.api.model.enums.Cor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record VideoDto(

        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotNull
        Cor cor,

        @NotBlank
        String url) {

    public static VideoDto of(Video video) {
        return VideoDto.builder()
                .titulo(video.getTitulo())
                .cor(video.getCategoria().getCor())
                .descricao(video.getDescricao())
                .url(video.getUrl())
                .build();
    }

}
