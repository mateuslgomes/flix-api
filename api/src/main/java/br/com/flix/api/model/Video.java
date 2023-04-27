package br.com.flix.api.model;

import br.com.flix.api.dtos.VideoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "videos")
@Entity(name = "video")
@Getter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;
    private String descricao;
    private String url;

    public static Video of(VideoDto dto) {
        return Video.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .url(dto.url())
                .build();
    }

}
