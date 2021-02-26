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

	public List<Pessoa> listarPessoaPorNome(FiltroConsultaPorNome filtro) {

		String pessoaNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<Pessoa> pessoas = pessoaRepository.findPessoaByNome(pessoaNome);

		return pessoas;
	}

	public List<Pessoa> listaPessoasPorSalaOuEspaco(FiltroConsultaPorNome filtro) {

		String salaOuEspacoNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<Pessoa> listaPessoas = pessoaRepositoryImpl.listaPessoasPorSalaOuEspaco(salaOuEspacoNome);

		return listaPessoas;
	}

	public void salvar(PessoaRequest pessoaDTORequest) {
		if (pessoaDTORequest.getNome() != null && pessoaDTORequest.getSobrenome() != null
				&& pessoaDTORequest.getSalas().get(0).getId() > 0
				&& pessoaDTORequest.getEspacosCafes().get(0).getId() > 0) {
			
			Sala sala = new Sala();
			sala.setId(pessoaDTORequest.getSalas().get(0).getId());
			
			List<Sala> salas  = new ArrayList<>();
			salas.add(sala);
			
			EspacoCafe espacoCafe = new EspacoCafe();
			espacoCafe.setId(pessoaDTORequest.getEspacosCafes().get(0).getId());

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(pessoaDTORequest.getNome());
			pessoa.setSobrenome(pessoaDTORequest.getSobrenome());
			pessoa.setSalas(salas);
			pessoa.setEspacocafe(espacoCafe);

			pessoaRepository.save(pessoa);
		}
	}
}
