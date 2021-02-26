package com.mateus.ferreira.gerenciamento.eventos.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mateus.ferreira.gerenciamento.eventos.entity.EspacoCafe;
import com.mateus.ferreira.gerenciamento.eventos.entity.Sala;

import lombok.Data;

@Data
public class PessoaEspecificaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1723573445041195166L;

	private Long id;

	private String nome;

	private String sobrenome;

	private List<Sala> salas = new ArrayList<>();

	private EspacoCafe espacoCafe;

}
