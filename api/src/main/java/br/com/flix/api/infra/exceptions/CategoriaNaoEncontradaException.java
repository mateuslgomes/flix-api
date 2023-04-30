package br.com.flix.api.infra.exceptions;

import java.util.UUID;

public class CategoriaNaoEncontradaException extends RuntimeException {

    public CategoriaNaoEncontradaException(UUID id) {
        super("Categoria com id " + id + " não encontrado");
    }

}
