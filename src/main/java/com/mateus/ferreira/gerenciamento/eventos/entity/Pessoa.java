package com.mateus.ferreira.gerenciamento.eventos.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	@OneToMany
	 @JoinTable(name="PESSOA_SALAEVENTO",
    joinColumns={@JoinColumn(name = "pessoa_id")},
    inverseJoinColumns={@JoinColumn(name = "salaevento_id")})
	private List<Sala> salas;
	
	@OneToOne
	 @JoinTable(name="PESSOA_ESPACOCAFE",
    joinColumns={@JoinColumn(name = "pessoa_id")},
    inverseJoinColumns={@JoinColumn(name = "espacocafe_id")})
	private EspacoCafe espacocafe;
}
