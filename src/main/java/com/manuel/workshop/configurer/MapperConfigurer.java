package com.manuel.workshop.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Configuration
public class MapperConfigurer {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
