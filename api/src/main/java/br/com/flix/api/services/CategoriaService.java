package br.com.flix.api.services;

import br.com.flix.api.dtos.requests.CategoriaDto;
import br.com.flix.api.dtos.response.CategoriaResponse;
import br.com.flix.api.infra.exceptions.CategoriaNaoEncontradaException;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.enums.Cor;
import br.com.flix.api.repositories.CategoriaRepository;
import br.com.flix.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    VideoRepository videoRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


    public Page<CategoriaResponse> findAll(Pageable pageable, int maxVideos) {
        Page<Categoria> categorias = categoriaRepository.findAll(pageable);
        List<CategoriaResponse> responses = new ArrayList<>();
        for (Categoria categoria : categorias) {
            var videos = videoRepository.findByCategorias(categoria, pageable);
            CategoriaResponse response = CategoriaResponse.of(categoria, maxVideos);
            responses.add(response);
        }
        return new PageImpl<>(responses, pageable, categorias.getTotalElements());
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
