package br.com.flix.api.services;

import br.com.flix.api.model.VideoCategoria;
import br.com.flix.api.repositories.VideoCategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoCategoriaService {

    private final VideoCategoriaRepository videoCategoriaRepository;

    public VideoCategoriaService(VideoCategoriaRepository videoCategoriaRepository) {
        this.videoCategoriaRepository = videoCategoriaRepository;
    }

    public VideoCategoria salvar(VideoCategoria videoCategoria) {
        return videoCategoriaRepository.save(videoCategoria);
    }

    public void excluir(VideoCategoria videoCategoria) {
        videoCategoriaRepository.delete(videoCategoria);
    }

}
