package com.mateus.ferreira.gerenciamento.eventos.entity;

import java.util.List;

import lombok.Data;

@Data
public class PessoaDTORequest {

	private Long id;

	private String nome;

	private String sobrenome;

	private List<Sala> salas;

	private List<EspacoCafe> espacosCafes;

}
