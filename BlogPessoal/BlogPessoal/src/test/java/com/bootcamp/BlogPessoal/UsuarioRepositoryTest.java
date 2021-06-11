package com.bootcamp.BlogPessoal;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.bootcamp.BlogPessoal.model.Usuario;

import antlr.collections.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
			
	@BeforeAll
	public void start() {
	
	Usuario usuario = new Usuario();
	usuario.setNome("Lu");
	if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
	usuarioRepository.save(usuario);
	
	usuario = new Usuario();
	usuario.setNome("maju");
	if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
	usuarioRepository.save(usuario);
	
	usuario = new Usuario();
	usuario.setNome("pot Lu");
	if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
	usuarioRepository.save(usuario);
	
	usuario = new Usuario();
	usuario.setNome("Lu sey");
	if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
	usuarioRepository.save(usuario);
	}
	
	@Test
	public void findByNomeRetornaUsuario() throws Exception {
	Usuario usuario = usuarioRepository.findFirstByNome("Lu");
	Assert.assertTrue(usuario.getNome().equals("Lu"));
	}
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresUsuario() {
	java.util.List<Usuario> usuarios = usuarioRepository
	.findAllByNomeIgnoreCaseContaining("chefe");
	Assert.assertEquals(3, usuarios.size());
	}@AfterAll
	public void end() {
	usuarioRepository.deleteAll();
	}
}
