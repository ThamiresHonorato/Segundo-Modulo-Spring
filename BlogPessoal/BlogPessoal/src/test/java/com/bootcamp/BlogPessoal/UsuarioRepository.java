package com.bootcamp.BlogPessoal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.BlogPessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findFirstByNome(String nome);
	public List<Usuario> findAllByNomeIgnoreCaseContaining(String nome);
	
}

	

