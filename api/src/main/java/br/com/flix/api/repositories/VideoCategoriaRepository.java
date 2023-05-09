package br.com.flix.api.repositories;

import br.com.flix.api.model.VideoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoCategoriaRepository extends JpaRepository<VideoCategoria, UUID> {
}
