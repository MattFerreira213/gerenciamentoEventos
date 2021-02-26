package com.mateus.ferreira.gerenciamento.eventos.reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.ferreira.gerenciamento.eventos.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	public List<Pessoa> findPessoaByNome(String nome);
	
}
