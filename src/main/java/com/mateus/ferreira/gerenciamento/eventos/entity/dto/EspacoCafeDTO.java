package com.mateus.ferreira.gerenciamento.eventos.entity.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EspacoCafeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -802726119193701876L;
	
	private Long id;
	
	private String nome;
	
	private Integer lotacao;

}
