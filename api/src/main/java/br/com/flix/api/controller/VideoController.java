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

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    VideoService videoService;


    @GetMapping
    public ResponseEntity<List<Video>> video() {
        return ResponseEntity.ok(videoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Video> video(@RequestBody @Valid VideoDto dto, UriComponentsBuilder uriBuilder) {
        var video = Video.of(dto) ;
        videoService.save(video);
        var uri = uriBuilder.path("video/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(video);
    }

}

