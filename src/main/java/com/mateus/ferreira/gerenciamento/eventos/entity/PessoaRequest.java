package com.mateus.ferreira.gerenciamento.eventos.entity;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PessoaRequest {

	private Long id;

	@NotBlank(message = "Campo nome é Obrigatorio! Em branco é não permitido.")
	private String nome;

	@NotBlank(message = "Campo sobrenome é Obrigatorio! Em branco é não permitido.")
	private String sobrenome;

	private List<Sala> salas;

	private List<EspacoCafe> espacosCafes;

}
