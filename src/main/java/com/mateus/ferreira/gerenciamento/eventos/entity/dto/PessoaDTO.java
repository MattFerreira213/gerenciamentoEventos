package com.mateus.ferreira.gerenciamento.eventos.entity.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PessoaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5409693065865824349L;

	private Long id;

	private String nome;
	
	private String sobrenome;

}
