package br.com.flix.api.repositories;

import br.com.flix.api.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<Video, UUID> {
    List<Video> findByCategoriasId(UUID id);

    Page<Video> findByTituloContains(String titulo, Pageable pageable);

}
