package com.hhr.recruitment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sharaf on 12/5/17.
 */
@Configuration

public class ModelConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
