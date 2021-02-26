package com.mateus.ferreira.gerenciamento.eventos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}