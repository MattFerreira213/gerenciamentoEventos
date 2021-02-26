package com.mateus.ferreira.gerenciamento.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.EspacoCafeRepository;

@Service
public class EspacoCafeService {

	@Autowired
	private EspacoCafeRepository espacoCafeRepository;

	public List<EspacoCafe> lista() {
		List<EspacoCafe> listaEspacoCafe = espacoCafeRepository.findAll();
		
		return listaEspacoCafe;
	}

	public void salvar(EspacoCafe espacoCafe) {
		
		EspacoCafe espacoCafeEncontrado = espacoCafeRepository.findEspacoCafeByNome(espacoCafe.getNome());
		
		if (espacoCafeEncontrado == null) {
			espacoCafeRepository.save(espacoCafe);
		}
	}
}
