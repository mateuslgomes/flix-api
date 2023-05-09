package br.com.flix.api;

import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.Video;
import br.com.flix.api.model.VideoCategoria;
import br.com.flix.api.repositories.VideoCategoriaRepository;
import br.com.flix.api.services.VideoCategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class VideoCategoriaServiceTest {

    private VideoCategoriaService videoCategoriaService;

    @Mock
    private VideoCategoriaRepository videoCategoriaRepositoryMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        videoCategoriaService = new VideoCategoriaService(videoCategoriaRepositoryMock);
    }

    @Test
    void deveSalvarNovaVideoCategoria() {
        // given
        Video video = new Video();
        video.setId(UUID.randomUUID());

        Categoria categoria = new Categoria();
        categoria.setId(UUID.randomUUID());

        VideoCategoria videoCategoria = new VideoCategoria(video.getId(), categoria.getId());

        when(videoCategoriaRepositoryMock.save(any(VideoCategoria.class))).thenReturn(videoCategoria);

        // when
        VideoCategoria videoCategoriaSalva = videoCategoriaService.salvar(videoCategoria);

        // then
        Assertions.assertEquals(videoCategoria, videoCategoriaSalva);
    }

    @Test
    void deveExcluirVideoCategoriaExistente() {
        // given
        Video video = new Video();
        video.setId(UUID.randomUUID());

        Categoria categoria = new Categoria();
        categoria.setId(UUID.randomUUID());

        VideoCategoria videoCategoria = new VideoCategoria(video.getId(), categoria.getId());

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return null;
            }
        }).when(videoCategoriaRepositoryMock).delete(any(VideoCategoria.class));

        // when
        videoCategoriaService.excluir(videoCategoria);

        // then
        // Se chegou até aqui é porque a exclusão foi bem sucedida
    }

}
