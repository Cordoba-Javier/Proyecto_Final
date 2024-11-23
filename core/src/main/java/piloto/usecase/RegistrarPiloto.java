package piloto.usecase;

import piloto.exception.ExceptionPiloto;
import piloto.input.CrearPiloto;
import piloto.modelo.Piloto;
import piloto.output.BaseDatos;

import java.util.UUID;

public class RegistrarPiloto implements CrearPiloto {
    private BaseDatos baseDatos;

    public RegistrarPiloto(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    @Override
    public boolean crearPiloto(String name, String surname, String full_name, String short_name, String picture_uri) throws ExceptionPiloto {
        Piloto piloto=Piloto.factory(UUID.randomUUID(), name, surname, full_name, short_name, picture_uri);
        if(baseDatos.consultaBD(piloto.getName()))
            throw new ExceptionPiloto("Exite piloto");
        return baseDatos.guardarBD(piloto);
    }
}
