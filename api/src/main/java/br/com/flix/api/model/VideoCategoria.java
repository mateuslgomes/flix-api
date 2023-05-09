package br.com.flix.api.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "videos_categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoCategoria {

    @EmbeddedId
    private VideoCategoriaId id;

    public VideoCategoria(UUID videoId, UUID categoriaId) {
        this.id = VideoCategoriaId.builder()
                .videoId(videoId)
                .categoriaId(categoriaId)
                .build();
    }

}
