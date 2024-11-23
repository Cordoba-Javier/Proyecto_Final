package ar.edu.undec.adapter.service.piloto;

import ar.edu.undec.adapter.service.controller.CrearPilotoControl;
import ar.edu.undec.adapter.service.entityDTO.PilotoEntityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import piloto.modelo.Piloto;
import piloto.output.BaseDatos;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControlerTest {
    @Mock
    BaseDatos baseDatos;

    @InjectMocks
    CrearPilotoControl crearPilotoControl;

    @Test
    public void crearPilotoControl_True() {
        Piloto piloto=Piloto.factory(UUID.randomUUID(),"name","surname","full_name","shr_name","uri");
        when(baseDatos.guardarBD(piloto)).thenReturn(true);
        PilotoEntityDTO pilotoDTO=new PilotoEntityDTO(null,"name","surname","full_name","shr_name","uri");
        ResponseEntity<?> result=crearPilotoControl.crearPiloto(pilotoDTO);
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void crearPilotoControl_False() {
        Piloto piloto=Piloto.factory(UUID.randomUUID(),"name","surname","full_name","shr_name","uri");
        when(baseDatos.guardarBD(piloto)).thenThrow(RuntimeException.class);
        PilotoEntityDTO pilotoDTO=new PilotoEntityDTO(null,"name","surname","full_name","shr_name","uri");
        ResponseEntity<?> result=crearPilotoControl.crearPiloto(pilotoDTO);
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}
