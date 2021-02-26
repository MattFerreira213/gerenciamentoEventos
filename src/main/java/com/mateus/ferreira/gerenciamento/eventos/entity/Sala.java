package com.mateus.ferreira.gerenciamento.eventos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	private String nome;
	
	private Integer lotacao;

}
