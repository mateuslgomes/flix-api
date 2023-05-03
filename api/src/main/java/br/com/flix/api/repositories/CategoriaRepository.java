package br.com.flix.api.repositories;

import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.enums.Cor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    Optional<Categoria> findByCor(Cor cor);

}
