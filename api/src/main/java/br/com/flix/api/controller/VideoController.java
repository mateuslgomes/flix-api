package br.com.flix.api.controller;

import br.com.flix.api.dtos.VideoDto;
import br.com.flix.api.model.Video;
import br.com.flix.api.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    VideoService videoService;


    @GetMapping
    public ResponseEntity<List<Video>> buscar() {
        return ResponseEntity.ok(videoService.findAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<VideoDto> atualizar(@PathVariable UUID id, @RequestBody @Valid VideoDto dto) {
        videoService.atualizar(dto, id);
        return ResponseEntity.ok(VideoDto.of(videoService.getReferenceById(id)));
    }

    @PostMapping
    public ResponseEntity<Video> cadastrar(@RequestBody @Valid VideoDto dto, UriComponentsBuilder uriBuilder) {
        var video = Video.of(dto) ;
        videoService.save(video);
        var uri = uriBuilder.path("video/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(video);
    }

}

