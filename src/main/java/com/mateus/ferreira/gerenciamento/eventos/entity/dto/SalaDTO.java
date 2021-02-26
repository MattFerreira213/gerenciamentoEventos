package com.mateus.ferreira.gerenciamento.eventos.entity.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SalaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7793705556303049908L;

	private Long id;

	private String nome;

	private Integer lotacao;

}
