package ar.edu.undec.adapter.data.repository;

import ar.edu.undec.adapter.data.crud.CrearPilotoCrud;
import ar.edu.undec.adapter.data.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import piloto.modelo.Piloto;
import piloto.output.BaseDatos;

@Repository
public class RegistrarPilotoRepository implements BaseDatos {
    private CrearPilotoCrud crud;

    @Autowired
    public RegistrarPilotoRepository(CrearPilotoCrud crud) {
        this.crud = crud;
    }


    @Override
    public boolean guardarBD(Piloto piloto) {
        try{
            crud.save(Mapper.dataMapper(piloto));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean consultaBD(String name) {
        return crud.existsPiloto(name);
    }
}
