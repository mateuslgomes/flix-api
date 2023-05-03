package br.com.flix.api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VideoNaoEncontradoException.class)
    ProblemDetail handleVideoNaoEncontradoException(VideoNaoEncontradoException ex) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Vídeo Não encontrado");
        problemDetail.setDetail("É preciso informar um ID de algum vídeo existente");
        problemDetail.setProperty("Categoria", "Not Found");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    ProblemDetail CategoriaNaoEncontradaException(CategoriaNaoEncontradaException ex) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Categoria Não encontrado");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("Categoria", "Not Found");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

}
