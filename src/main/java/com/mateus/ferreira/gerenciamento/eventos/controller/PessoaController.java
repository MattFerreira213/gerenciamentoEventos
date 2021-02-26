package com.mateus.ferreira.gerenciamento.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.entity.PessoaDTORequest;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.entity.dto.PessoaDTO;
import com.mateus.ferreira.gerenciamento.eventos.entity.dto.PessoaEspecificaDTO;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.SalaRepository;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.filtro.PessoaFiltro;
import com.mateus.ferreira.gerenciamento.eventos.reposotiry.filtro.SalaOuEspacoFiltro;
import com.mateus.ferreira.gerenciamento.eventos.service.EspacoCafeService;
import com.mateus.ferreira.gerenciamento.eventos.service.PessoaService;
import com.mateus.ferreira.gerenciamento.eventos.service.SalaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private SalaService salaService;

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private EspacoCafeService espacoCafeService;


	@GetMapping("/cadastro")
	public ModelAndView cadastraPessoa() {
		ModelAndView mv = new ModelAndView("CadastrarPessoa");
		return mv;
	}

	@RequestMapping("/lista/pornome")
	public ModelAndView listarPessoaPorNome(@ModelAttribute("filtro") PessoaFiltro filtro) {
		List<PessoaEspecificaDTO> pessoa = pessoaService.listarPessoaPorNome(filtro);

		ModelAndView mv = new ModelAndView("ListarPessoaPorNome");
		mv.addObject("pessoa", pessoa);

		return mv;
	}

	@RequestMapping("/lista/porsalaouespaco")
	public ModelAndView listaPessoasPorSalaOuEspaco(@ModelAttribute("filtro") SalaOuEspacoFiltro filtro) {
		List<PessoaDTO> listaPessoas = pessoaService.listaPessoasPorSalaOuEspaco(filtro);
		ModelAndView md = new ModelAndView("ListarPessoasPorEspacoOuSala");
		md.addObject("pessoas", listaPessoas);
		return md;
	}

	@RequestMapping("{id}")
	public ModelAndView selecao(@PathVariable("id") Long id) {
		Sala sala = salaRepository.getOne(id);
		ModelAndView mv = new ModelAndView("/sala/cadastro");
		mv.addObject(sala);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(PessoaDTORequest pessoaDTORequest) {

		pessoaService.salvar(pessoaDTORequest);

		return "CadastrarPessoa";
	}

	@ModelAttribute("todasSalas")
	public PessoaDTORequest todasSalas() {
		List<Sala> salas = salaService.lista();
		PessoaDTORequest todasSalas = new PessoaDTORequest();
		todasSalas.setSalas(salas);

		return todasSalas;
	}

	@ModelAttribute("todosEspacoCafe")
	public PessoaDTORequest todosEspacoCafe() {
		List<EspacoCafe> espacosCafes = espacoCafeService.lista();
		PessoaDTORequest todosEspacoCafe = new PessoaDTORequest();
		todosEspacoCafe.setEspacosCafes(espacosCafes);

		return todosEspacoCafe;
	}
}
