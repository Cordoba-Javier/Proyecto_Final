package ar.edu.undec.adapter.data.mapper;

import ar.edu.undec.adapter.data.entityData.PilotoEntityData;
import piloto.modelo.Piloto;

public class Mapper {
    public static Piloto coreMapper(PilotoEntityData pilotoEntityData){
        return Piloto.factory(pilotoEntityData.getIdPiloto(),
                pilotoEntityData.getName(),
                pilotoEntityData.getSurname(),
                pilotoEntityData.getFull_name(),
                pilotoEntityData.getShort_name(),
                pilotoEntityData.getPicture_uri());
    }

    public static PilotoEntityData dataMapper(Piloto piloto){
        return PilotoEntityData.crearEntityData(piloto);
    }
}
