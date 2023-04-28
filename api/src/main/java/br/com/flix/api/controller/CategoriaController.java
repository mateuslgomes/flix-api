package br.com.flix.api.controller;

import br.com.flix.api.dtos.CategoriaDto;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaDto dto) {
        var categoria = Categoria.of(dto);
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

}
