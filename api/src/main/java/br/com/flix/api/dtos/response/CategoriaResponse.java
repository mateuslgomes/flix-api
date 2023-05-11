package br.com.flix.api.dtos.response;

import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.Video;
import br.com.flix.api.model.enums.Cor;
import lombok.Builder;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
public record CategoriaResponse(UUID id, String titulo, Cor cor, List<UUID> videoId) {

    public static CategoriaResponse of(Categoria categoria, int maxVideos) {
        List<UUID> videoIds = categoria.getVideos().stream()
                .limit(maxVideos)
                .map(Video::getId)
                .collect(Collectors.toList());
        return CategoriaResponse.builder()
                .id(categoria.getId())
                .titulo(categoria.getTitulo())
                .cor(categoria.getCor())
                .videoId(videoIds)
                .build();
    }

}
