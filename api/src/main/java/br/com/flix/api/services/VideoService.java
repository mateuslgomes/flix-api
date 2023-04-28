package br.com.flix.api.services;

import br.com.flix.api.dtos.VideoDto;
import br.com.flix.api.infra.exceptions.VideoNaoEncontradoException;
import br.com.flix.api.model.Video;
import br.com.flix.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    public Optional<Video> findById(UUID id) {
        return videoRepository.findById(id);
    }

    @Transactional
    public void deleteById(UUID id) {
        videoRepository.deleteById(id);
    }

    public Video atualizar(UUID id, VideoDto dto) {
        var video = videoRepository.findById(id)
                .orElseThrow(() -> new VideoNaoEncontradoException(id));
        video.atualizar(dto);
        return video;
    }

}
