package piloto.usecase;

import piloto.input.MostrarPilotos;
import piloto.modelo.Piloto;
import piloto.output.BaseDatos;
import java.util.List;

public class PilotosOutput implements MostrarPilotos {
    private BaseDatos baseDatos;
    public PilotosOutput(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    @Override
    public List<Piloto> getPilotos() {
        return baseDatos.obtenerPilotos();
    }
}
