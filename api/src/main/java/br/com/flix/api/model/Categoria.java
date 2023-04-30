package br.com.flix.api.model;

import br.com.flix.api.dtos.CategoriaDto;
import br.com.flix.api.model.enums.Cor;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "categorias")
@Entity(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    public static Categoria of(CategoriaDto dto) {
        return Categoria.builder()
                .titulo(dto.titulo())
                .cor(dto.cor())
                .build();
    }

    public void atualizar(CategoriaDto dto) {
        this.titulo = dto.titulo();
        this.cor = dto.cor();
    }

}
