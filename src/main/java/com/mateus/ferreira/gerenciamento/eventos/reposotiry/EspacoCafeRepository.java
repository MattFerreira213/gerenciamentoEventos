package com.mateus.ferreira.gerenciamento.eventos.reposotiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;

@Repository
public interface EspacoCafeRepository extends JpaRepository<EspacoCafe, Long> {
	public EspacoCafe findEspacoCafeByNome(String nome);

}
