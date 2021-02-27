package com.mateus.ferreira.gerenciamento.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.entity.Pessoa;
import com.mateus.ferreira.gerenciamento.eventos.entity.PessoaRequest;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.service.EspacoCafeService;
import com.mateus.ferreira.gerenciamento.eventos.service.PessoaService;
import com.mateus.ferreira.gerenciamento.eventos.service.SalaService;
import com.mateus.ferreira.gerenciamento.eventos.util.filtro.FiltroConsultaPorNome;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private SalaService salaService;

	@Autowired
	private EspacoCafeService espacoCafeService;


	@GetMapping("/cadastro")
	public ModelAndView cadastraPessoa() {
		ModelAndView mv = new ModelAndView("CadastrarPessoa");
		mv.addObject(new PessoaRequest());
		return mv;
	}

	@RequestMapping("/lista/pornome")
	public ModelAndView listarPessoaPorNome(@ModelAttribute("filtro") FiltroConsultaPorNome filtro) {
		List<Pessoa> pessoa = pessoaService.listarPessoaPorNome(filtro);

		ModelAndView mv = new ModelAndView("ListarPessoaPorNome");
		mv.addObject("pessoa", pessoa);

		return mv;
	}

	@RequestMapping("/lista/porsalaouespaco")
	public ModelAndView listaPessoasPorSalaOuEspaco(@ModelAttribute("filtro") FiltroConsultaPorNome filtro) {
		List<Pessoa> listaPessoas = pessoaService.listaPessoasPorSalaOuEspaco(filtro);
		ModelAndView md = new ModelAndView("ListarPessoasPorEspacoOuSala");
		md.addObject("pessoas", listaPessoas);
		return md;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated PessoaRequest pessoaRequest, Errors errors) {
		if(errors.hasErrors()) {
			return "CadastrarPessoa";
		}
		pessoaService.salvar(pessoaRequest);
		return "CadastrarPessoa";
	}

	@ModelAttribute("todasSalas")
	public PessoaRequest todasSalas() {
		List<Sala> salas = salaService.lista();
		PessoaRequest todasSalas = new PessoaRequest();
		todasSalas.setSalas(salas);

		return todasSalas;
	}

	@ModelAttribute("todosEspacoCafe")
	public PessoaRequest todosEspacoCafe() {
		List<EspacoCafe> espacosCafes = espacoCafeService.lista();
		PessoaRequest todosEspacoCafe = new PessoaRequest();
		todosEspacoCafe.setEspacosCafes(espacosCafes);

		return todosEspacoCafe;
	}
}

