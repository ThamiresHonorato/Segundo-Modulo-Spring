package com.bootcamp.BlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.BlogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
}