package br.com.flix.api.controller;

import br.com.flix.api.dtos.requests.CategoriaDto;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<Categoria>> buscar() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable UUID id, @RequestBody @Valid CategoriaDto dto) {
        return ResponseEntity.ok(categoriaService.atualizar(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
