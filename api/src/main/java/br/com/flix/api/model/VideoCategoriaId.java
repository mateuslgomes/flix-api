package br.com.flix.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class VideoCategoriaId implements Serializable {


    @Column(name = "video_id")
    private UUID videoId;

    @Column(name = "categoria_id")
    private UUID categoriaId;

}
