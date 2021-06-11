package com.bootcamp.BlogPessoal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.bootcamp.BlogPessoal.model.Usuario;

//revisar
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public Usuario usuario;
	
	@Autowired
	private final Validator validator = Validation
	.buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	public void start() {
	Usuario usuario = new Usuario();
	}
	
	@Test
	public void testValidationAtributos(){
		
		usuario.setNome("João");
		usuario.setUsuario("J.J");
		usuario.setSenha("12345");
		
	Set<ConstraintViolation<Usuario>> violations = validator
	.validate(usuario);
	System.out.println(violations.toString());
	assertTrue(violations.isEmpty());
	}

}
	
