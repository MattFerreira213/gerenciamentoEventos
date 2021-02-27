package com.mateus.ferreira.gerenciamento.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.service.EspacoCafeService;

@Controller
@RequestMapping("/espacocafe")
public class EspacoCafeController {

	@Autowired private EspacoCafeService espacoCafeService;
	
	@GetMapping("/cadastro")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("CadastrarEspacoCafe");
		mv.addObject(new EspacoCafe());
		return mv;
	}		 
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated EspacoCafe espacoCafe, Errors errors) {
		if(errors.hasErrors()) {
			return "CadastrarEspacoCafe";
		}
		
		espacoCafeService.salvar(espacoCafe);
		return "CadastrarEspacoCafe";
	}
}
