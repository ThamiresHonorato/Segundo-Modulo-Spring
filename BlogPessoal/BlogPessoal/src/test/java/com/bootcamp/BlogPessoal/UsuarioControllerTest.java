package com.bootcamp.BlogPessoal;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bootcamp.BlogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	private Usuario usuario;
	private Usuario usuarioupd;
	@BeforeAll
	public void start() {
		usuario = new Usuario();
		usuario.setNome("Lala");
		usuario.setSenha("1234");
		usuario.setUsuario("L.L");
		
		usuarioupd = new Usuario();
		usuarioupd.setNome("Jojo");
		usuarioupd.setSenha("12345");
		usuarioupd.setUsuario("J.J");
	}
	@Test
	public void deveRealizarPostUsuarios() {
	HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
	ResponseEntity<Usuario> resposta = testRestTemplate
	.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.clas
	Assert.assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	@Disabled
	@Test
	public void deveMostrarTodosUsuarios() {
	ResponseEntity<String> resposta = testRestTemplate
	.exchange("/usuarios/", HttpMethod.GET, null, String.class);
	Assert.assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	@Disabled
	@Test
	public void deveRealizarPutUsuarios() {
	HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioupd);
	ResponseEntity<Usuario> resposta = testRestTemplate
	.exchange("/usuarios/alterar", HttpMethod.PUT, request, Usuario.class
	Assert.assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	@Disabled
	@Test
	public void deveRealizarDeleteUsuarios() {
	ResponseEntity<String> resposta = testRestTemplate
	.exchange("/usuarios/3", HttpMethod.DELETE, null, String.class);
	Assert.assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	

}
