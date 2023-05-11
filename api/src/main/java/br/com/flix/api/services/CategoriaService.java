package br.com.flix.api.services;

import br.com.flix.api.dtos.requests.CategoriaDto;
import br.com.flix.api.dtos.response.CategoriaResponse;
import br.com.flix.api.dtos.response.VideoResponse;
import br.com.flix.api.infra.exceptions.CategoriaNaoEncontradaException;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.Video;
import br.com.flix.api.model.enums.Cor;
import br.com.flix.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Page<CategoriaResponse> findAll(Pageable pageable) {
        Page<Categoria> categorias = categoriaRepository.findAll(pageable);
        return categorias.map(CategoriaResponse::of);
    }


    public Categoria findById(UUID id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    public Categoria findByCor(Cor cor) {
        return categoriaRepository.findByCor(cor)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(cor));
    }

    @Transactional
    public Categoria atualizar(UUID id, CategoriaDto dto) {
        var categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
        categoria.atualizar(dto);
        return categoria;
    }

    @Transactional
    public void deleteById(UUID id) {
        categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
        categoriaRepository.deleteById(id);
    }

}
