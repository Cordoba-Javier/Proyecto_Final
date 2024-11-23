package ar.edu.undec.adapter.data.piloto;

import ar.edu.undec.adapter.data.crud.CrearPilotoCrud;
import ar.edu.undec.adapter.data.entityData.PilotoEntityData;
import ar.edu.undec.adapter.data.repository.RegistrarPilotoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import piloto.modelo.Piloto;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearPilotoDataTest {
    @Mock
    CrearPilotoCrud crud;

    @InjectMocks
    RegistrarPilotoRepository registrarPilotoRepository;

    @Test
    public void crearPiloto_SaveCrud() {
        Piloto piloto=Piloto.factory(UUID.randomUUID(),"name","surname","full_name","short_name","uri");
        when(crud.save(any(PilotoEntityData.class))).thenReturn(new PilotoEntityData());
        boolean result = registrarPilotoRepository.guardarBD(piloto);
        Assertions.assertTrue(result);
    }

    @Test
    public void crearPiloto_Exeption() {
        Piloto piloto=Piloto.factory(UUID.randomUUID(),"name","surname","full_name","short_name","uri");
        when(crud.save(any(PilotoEntityData.class))).thenThrow(RuntimeException.class);
        boolean result = registrarPilotoRepository.guardarBD(piloto);
        Assertions.assertFalse(result);
    }

}
