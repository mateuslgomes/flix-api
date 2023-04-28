package br.com.flix.api;

import br.com.flix.api.dtos.CategoriaDto;
import br.com.flix.api.model.Categoria;
import br.com.flix.api.model.enums.Cor;
import br.com.flix.api.repositories.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Test
	void contextLoads() {
		var dto = new CategoriaDto("CARRO", Cor.ROXO);
		var categoria = Categoria.of(dto);
		categoriaRepository.save(categoria);
	}

	@Test
	void a() {
		var categora = categoriaRepository.findAll();

		Assertions.assertNotNull(categora, "A categoria não deve ser nula");
		Assertions.assertNotNull(categora.get(0).getId(), "O id da categoria deve ser 1");
		Assertions.assertEquals("CARRO", categora.get(0).getTitulo(), "O titulo da categoria deve ser CARRO");
		Assertions.assertEquals(Cor.ROXO, categora.get(0).getCor(), "A cor da categoria deve ser ROXO");
	}

}
