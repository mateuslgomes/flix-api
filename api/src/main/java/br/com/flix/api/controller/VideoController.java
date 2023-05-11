package br.com.flix.api.controller;

import br.com.flix.api.dtos.requests.VideoDto;
import br.com.flix.api.dtos.response.VideoResponse;
import br.com.flix.api.services.CategoriaService;
import br.com.flix.api.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    VideoService videoService;


    @GetMapping
    public ResponseEntity<Page<VideoResponse>> buscadorVideos(@RequestParam(value = "search", required = false) String pesquisa,
                                                              @PageableDefault(sort = "titulo", direction = Sort.Direction.ASC) Pageable pageable) {
        if (pesquisa == null) {
            return ResponseEntity.ok(videoService.findAll(pageable));
        }
        return ResponseEntity.ok(videoService.pesquisarVideos(pesquisa, pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity<VideoResponse> atualizar(@PathVariable UUID id, @RequestBody @Valid VideoDto dto) {
        var video = videoService.atualizar(id, dto);
        return ResponseEntity.ok(VideoResponse.of(video));
    }

    @GetMapping("{id}")
    public ResponseEntity<VideoResponse> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(VideoResponse.of(videoService.findById(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        videoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<VideoResponse> cadastrar(@RequestBody @Valid VideoDto dto) {
        return ResponseEntity.ok(videoService.save(dto));
    }

}
