package com.mateus.ferreira.gerenciamento.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TelaPrincipalController {

	@GetMapping()
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("TelaPrincipal");
		return mv;
	}

}