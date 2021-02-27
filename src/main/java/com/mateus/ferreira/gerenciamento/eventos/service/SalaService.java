package com.mateus.ferreira.gerenciamento.eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;

	/**
	 * Método responsável por listar as salas na tela de cadastro de pessoas
	 * @return
	 */
	public List<Sala> lista() {
		List<Sala> listaSala = salaRepository.findAll();
		
		return listaSala;
	}
	
	/**
	 * Método responsável por salvar uma sala do evento
	 * @param salaEvento
	 */
	public void salvar(Sala salaEvento) {
		Sala sala = salaRepository.findSalaByNome(salaEvento.getNome());
		
		if (sala == null) {
			salaRepository.save(salaEvento);
		}
	}
}
