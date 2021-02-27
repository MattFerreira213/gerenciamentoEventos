package com.mateus.ferreira.gerenciamento.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
		mv.addObject(new Sala());
		return mv;
	}		
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Sala sala, Errors errors) {
		if(errors.hasErrors()) {
			return "CadastrarSala";
		}
		salaService.salvar(sala);
		
		return "CadastrarSala";
	}
}