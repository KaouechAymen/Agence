package de.tekup.projet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfig {
	
	@Bean
	public ModelMapper getMoelMapper() {
		return new ModelMapper();
	}

}