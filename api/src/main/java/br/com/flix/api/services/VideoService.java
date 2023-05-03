package br.com.flix.api.services;

import br.com.flix.api.dtos.requests.VideoDto;
import br.com.flix.api.dtos.response.VideoResponse;
import br.com.flix.api.infra.exceptions.VideoNaoEncontradoException;
import br.com.flix.api.model.Video;
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

    @Transactional
    public void save(Video video) {
        videoRepository.save(video);
    }

    public List<VideoResponse> findAll() {
        List<Video> videos = videoRepository.findAll();
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

}
