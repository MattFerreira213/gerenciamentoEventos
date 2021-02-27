package com.mateus.ferreira.gerenciamento.eventos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.entity.Pessoa;
import com.mateus.ferreira.gerenciamento.eventos.entity.PessoaRequest;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.PessoaRepository;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.PessoaRepositoryImpl;
import com.mateus.ferreira.gerenciamento.eventos.util.filtro.FiltroConsultaPorNome;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaRepositoryImpl pessoaRepositoryImpl;
	
	/**
	 * Método responsável por listar todos os dados de uma pessoa específica
	 * @param filtro
	 * @return Lista com dados de uma pessoa específica
	 */
	public List<Pessoa> listarPessoaPorNome(FiltroConsultaPorNome filtro) {

		String pessoaNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<Pessoa> pessoas = pessoaRepository.findPessoaByNome(pessoaNome);

		return pessoas;
	}

	/**
	 * Método responsável por listar todas as pessoas que estaram em uma sala ou espaço de café
	 * @param filtro
	 * @return Lista de pessoas
	 */
	public List<Pessoa> listaPessoasPorSalaOuEspaco(FiltroConsultaPorNome filtro) {

		String salaOuEspacoNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<Pessoa> listaPessoas = pessoaRepositoryImpl.listaPessoasPorSalaOuEspaco(salaOuEspacoNome);

		return listaPessoas;
	}

	/**
	 * Método responsável por salvar as pessoas participantes dos eventos
	 * @param pessoaRequest
	 */
	public void salvar(PessoaRequest pessoaRequest) {
		if (pessoaRequest.getNome() != null && pessoaRequest.getSobrenome() != null
				&& pessoaRequest.getSalas().get(0).getId() > 0
				&& pessoaRequest.getEspacosCafes().get(0).getId() > 0) {
			
			Sala sala = new Sala();
			sala.setId(pessoaRequest.getSalas().get(0).getId());
			
			List<Sala> salas  = new ArrayList<>();
			salas.add(sala);
			
			EspacoCafe espacoCafe = new EspacoCafe();
			espacoCafe.setId(pessoaRequest.getEspacosCafes().get(0).getId());

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(pessoaRequest.getNome());
			pessoa.setSobrenome(pessoaRequest.getSobrenome());
			pessoa.setSalas(salas);
			pessoa.setEspacocafe(espacoCafe);

			pessoaRepository.save(pessoa);
		}
	}
}
