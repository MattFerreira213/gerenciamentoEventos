package com.mateus.ferreira.gerenciamento.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;
import com.mateus.ferreira.gerenciamento.eventos.service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/cadastro")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("CadastrarSala");
		return mv;
	}		
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Sala sala) {
		salaService.salvar(sala);
		
		return "CadastrarEspacoCafe";
	}
}
