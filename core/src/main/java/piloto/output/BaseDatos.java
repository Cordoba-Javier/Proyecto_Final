package piloto.output;

import piloto.modelo.Piloto;


import java.util.List;

public interface BaseDatos {
    public boolean guardarBD(Piloto piloto);
    public boolean consultaBD(String name);
    public List<Piloto> obtenerPilotos();
}
