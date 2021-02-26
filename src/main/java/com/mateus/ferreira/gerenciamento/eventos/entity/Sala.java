package com.mateus.ferreira.gerenciamento.eventos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "salaevento")
public class Sala {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank(message = "Campo nome é Obrigatorio! Em branco é não permitido.")
	private String nome;
	
	@NotNull(message = "Campo lotação é Obrigatorio! Não permitido menos que 1.")
	@Min(1)
	private Integer lotacao;

}
