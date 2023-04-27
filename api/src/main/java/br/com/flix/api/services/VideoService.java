package br.com.flix.api.services;

import br.com.flix.api.dtos.VideoDto;
import br.com.flix.api.model.Video;
import br.com.flix.api.repositories.VideoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Transactional
    public void save(Video video) {
        videoRepository.save(video);
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Transactional
    public void atualizar(VideoDto dto, UUID id) {
        var video = videoRepository.getReferenceById(id);
        video.atualizar(dto);
    }

    public Video getReferenceById(UUID id) {
        return videoRepository.getReferenceById(id);
    }

    public Object findById(UUID id) {
        var resultado = videoRepository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return "Não foi possível encontrar o modelo com o id " + id;
        }
    }

}
