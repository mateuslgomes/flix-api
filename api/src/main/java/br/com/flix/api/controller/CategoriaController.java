package br.com.flix.api.controller;

import br.com.flix.api.dtos.requests.CategoriaDto;
import br.com.flix.api.dtos.response.CategoriaResponse;
import br.com.flix.api.dtos.response.VideoResponse;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.services.CategoriaService;
import br.com.flix.api.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    VideoService videoService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaDto dto) {
        var categoria = Categoria.of(dto);
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @GetMapping("{id}/videos")
     public ResponseEntity<List<VideoResponse>> buscarVideoByCategoria(@PathVariable UUID id){
        return ResponseEntity.ok(videoService.findVideoByCategoria(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> buscar() {
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
