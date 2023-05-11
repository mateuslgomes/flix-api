package br.com.flix.api.services;

import br.com.flix.api.dtos.requests.VideoDto;
import br.com.flix.api.dtos.response.VideoResponse;
import br.com.flix.api.infra.exceptions.CategoriaNaoEncontradaException;
import br.com.flix.api.infra.exceptions.VideoNaoEncontradoException;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.Video;
import br.com.flix.api.model.enums.Cor;
import br.com.flix.api.repositories.CategoriaRepository;
import br.com.flix.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public VideoResponse save(VideoDto dto) {
        var video = new Video();
        Categoria categoria = null;
        if (dto.cor() != null) {
            categoria = categoriaRepository.findByCor(dto.cor())
                    .orElseThrow(() -> new CategoriaNaoEncontradaException(dto.cor()));
        } if (categoria == null) {
            categoria = categoriaRepository.findByCor(Cor.VERDE).get();
        }
        video.atualizar(dto, categoria);
        videoRepository.save(video);
        return VideoResponse.of(video);
    }

    public List<VideoResponse> findAll() {
        var videos = videoRepository.findAll();
        return videos.stream()
                .map(VideoResponse::of)
                .collect(Collectors.toList());
    }

    public Video findById(UUID id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new VideoNaoEncontradoException(id));
    }

    @Transactional
    public void deleteById(UUID id) {
        videoRepository.findById(id)
                .orElseThrow(() -> new VideoNaoEncontradoException(id));
        videoRepository.deleteById(id);
    }

    public Video atualizar(UUID id, VideoDto dto) {
        var video = videoRepository.findById(id)
                .orElseThrow(() -> new VideoNaoEncontradoException(id));
        video.atualizar(dto);
        return video;
    }

    public List<VideoResponse> findVideoByCategoria(UUID id) {
        var videos = videoRepository.findByCategoriasId(id);
        return videos.stream()
                .map(VideoResponse::of)
                .collect(Collectors.toList());
    }

    public List<VideoResponse> pesquisarVideos(String pesquisa) {
         var videos = videoRepository.findByTituloContains(pesquisa);
        return videos.stream()
                .map(VideoResponse::of)
                .collect(Collectors.toList());
    }

}
