package br.com.flix.api.model;

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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Cor cor;

}
