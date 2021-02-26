package com.mateus.ferreira.gerenciamento.eventos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.entity.Pessoa;
import com.mateus.ferreira.gerenciamento.eventos.entity.PessoaDTORequest;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.entity.dto.PessoaDTO;
import com.mateus.ferreira.gerenciamento.eventos.entity.dto.PessoaEspecificaDTO;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.PessoaRepository;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.PessoaRepositoryImpl;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.filtro.PessoaFiltro;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.filtro.SalaOuEspacoFiltro;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaRepositoryImpl pessoaRepositoryImpl;

	@Autowired
	private ModelMapper modelMapper;

	public List<PessoaEspecificaDTO> listarPessoaPorNome(PessoaFiltro filtro) {

		String pessoaNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<PessoaEspecificaDTO> pessoaEspecificaDTOs = pessoaRepository.findPessoaByNome(pessoaNome).stream()
				.map(entity -> modelMapper.map(entity, PessoaEspecificaDTO.class)).collect(Collectors.toList());

		return pessoaEspecificaDTOs;
	}

	public List<PessoaDTO> listaPessoasPorSalaOuEspaco(SalaOuEspacoFiltro filtro) {

		String salaOuEspacoNome = filtro.getNome() == null ? "" : filtro.getNome();

		List<PessoaDTO> listaPessoas = pessoaRepositoryImpl.listaPessoasPorSalaOuEspaco(salaOuEspacoNome).stream()
				.map(entity -> modelMapper.map(entity, PessoaDTO.class)).collect(Collectors.toList());

		return listaPessoas;
	}

	public void salvar(PessoaDTORequest pessoaDTORequest) {
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
