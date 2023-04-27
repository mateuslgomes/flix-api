package br.com.flix.api.services;

import br.com.flix.api.model.Video;
import br.com.flix.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public void save(Video video) {
        videoRepository.save(video);
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }
}
