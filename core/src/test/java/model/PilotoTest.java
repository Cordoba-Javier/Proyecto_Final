package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import piloto.exception.ExceptionPiloto;
import piloto.modelo.Piloto;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class PilotoTest {
    private UUID idPiloto=UUID.randomUUID();

    @Test
    public void testPilotoFactory_True() {
        Piloto piloto=Piloto.factory(idPiloto,"name","surname","full_name","short_name","uri");
        Assertions.assertNotNull(piloto);
    }

    @Test
    public void testPilotoFactory_Exeptions() {
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(null,"name","surname","full_name","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,null,"surname","full_name","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name",null,"full_name","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname",null,"short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname","full_name",null,"uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname","full_name","short_name",null));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"","surname","full_name","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","","full_name","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname","","short_name","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname","full_name","","uri"));
        Assertions.assertThrows(ExceptionPiloto.class,()->Piloto.factory(idPiloto,"name","surname","full_name","short_name",""));
    }
}
