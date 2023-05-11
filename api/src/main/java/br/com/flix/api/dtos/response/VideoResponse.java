package br.com.flix.api.dtos.response;

import br.com.flix.api.model.Video;
import br.com.flix.api.model.enums.Cor;
import lombok.Builder;

import java.util.UUID;

@Builder
public record VideoResponse(UUID id, String titulo, String descricao, UUID CategoriaId, String url) {

    public static VideoResponse of(Video video) {
        var builder = VideoResponse.builder()
                .id(video.getId())
                .titulo(video.getTitulo())
                .descricao(video.getDescricao())
                .url(video.getUrl());
        if (video.getCategorias() != null) {
            builder.CategoriaId(video.getCategorias().getId());
        }
        return builder.build();
    }

}
