package usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import piloto.exception.ExceptionPiloto;
import piloto.modelo.Piloto;
import piloto.output.BaseDatos;
import piloto.usecase.RegistrarPiloto;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistaraPilotoTest {
    private UUID idPiloto=UUID.randomUUID();

    @Mock
    private BaseDatos baseDatos;
    private RegistrarPiloto registrarPiloto;

    @BeforeEach
    public void setUp() {
        registrarPiloto = new RegistrarPiloto(baseDatos);
    }

    @Test
    public void registrarPiloto_True() {
        Piloto piloto= Piloto.factory(idPiloto,"name","surname","full_name","short_name","uri");
        when(baseDatos.consultaBD(piloto.getName())).thenReturn(false);
        when(baseDatos.guardarBD(piloto)).thenReturn(true);
        boolean result= registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri());
        Assertions.assertTrue(result);
    }

    @Test
    public void registrarPiloto_PilotoExist() {
        Piloto piloto= Piloto.factory(idPiloto,"name","surname","full_name","short_name","uri");
        when(baseDatos.consultaBD(piloto.getName())).thenReturn(true);
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri()));
    }

    @Test
    public void registrarPiloto_False_Exceptions() {
        Piloto piloto= Piloto.factory(idPiloto,"name","surname","full_name","short_name","uri");
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(null,piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),null,piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),null,piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),null,piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),null));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto("",piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),"",piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),"",piloto.getShort_name(),piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),"",piloto.getPicture_uri()));
        Assertions.assertThrows(ExceptionPiloto.class,()->registrarPiloto.crearPiloto(piloto.getName(),piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),""));
    }
}
