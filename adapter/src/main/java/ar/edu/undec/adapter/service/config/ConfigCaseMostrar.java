package ar.edu.undec.adapter.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import piloto.input.MostrarPilotos;
import piloto.output.BaseDatos;
import piloto.usecase.PilotosOutput;

@Configuration
public class ConfigCaseMostrar {
    @Bean
    public MostrarPilotos mostrarPilotos(BaseDatos baseDatos) {
        return new PilotosOutput(baseDatos);
    }
}
