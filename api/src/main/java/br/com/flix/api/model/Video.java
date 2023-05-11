package br.com.flix.api.model;

import br.com.flix.api.dtos.requests.VideoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "videos")
@Entity(name = "video")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;
    private String descricao;
    private String url;

    @ManyToOne
    private Categoria categorias;

    public static Video of(VideoDto dto) {
        return Video.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .url(dto.url())
                .build();
    }

    public static Video of(VideoDto dto, Categoria categoria) {
        return Video.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .url(dto.url())
                .categorias(categoria)
                .build();
    }

    public void atualizar(VideoDto dto) {
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
        this.url = dto.url();
    }

    public void atualizar(VideoDto dto, Categoria categoria) {
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
        this.categorias = categoria;
        this.url = dto.url();
    }

}
