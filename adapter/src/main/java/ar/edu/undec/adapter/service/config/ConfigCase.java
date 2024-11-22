package ar.edu.undec.adapter.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import piloto.input.CrearPiloto;
import piloto.output.BaseDatos;
import piloto.usecase.RegistrarPiloto;

@Configuration
public class ConfigCase {
    @Bean
    public CrearPiloto crearPiloto(BaseDatos bd) {
        return new RegistrarPiloto(bd);
    }
}
