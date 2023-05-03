package br.com.flix.api.infra.exceptions;

import br.com.flix.api.model.enums.Cor;

import java.util.UUID;

public class CategoriaNaoEncontradaException extends RuntimeException {

    public CategoriaNaoEncontradaException(UUID id) {
        super("Categoria com id " + id + " não encontrado");
    }

    public CategoriaNaoEncontradaException(Cor cor) {
        super("Categoria com a cor " + cor + " não encontrado");
    }

}
