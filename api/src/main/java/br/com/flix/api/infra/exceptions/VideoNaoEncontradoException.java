package br.com.flix.api.infra.exceptions;

import java.util.UUID;

public class VideoNaoEncontradoException extends RuntimeException {

    public VideoNaoEncontradoException(UUID id) {
        super("Video com id " + id + " não encontrado");
    }

}
