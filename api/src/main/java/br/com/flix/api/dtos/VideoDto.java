package br.com.flix.api.dtos;

import br.com.flix.api.model.Video;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record VideoDto(

        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotBlank
        String url) {

    public static VideoDto of(Video video) {
        return VideoDto.builder()
                .titulo(video.getTitulo())
                .descricao(video.getDescricao())
                .url(video.getUrl())
                .build();
    }

}
