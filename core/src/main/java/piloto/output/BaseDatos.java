package piloto.output;

import piloto.modelo.Piloto;

public interface BaseDatos {
    public boolean guardarBD(Piloto piloto);
    public boolean consultaBD(String name);
}
