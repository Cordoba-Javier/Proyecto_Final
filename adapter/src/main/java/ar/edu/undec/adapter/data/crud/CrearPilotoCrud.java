package ar.edu.undec.adapter.data.crud;

import ar.edu.undec.adapter.data.entityData.PilotoEntityData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrearPilotoCrud extends CrudRepository<PilotoEntityData, String> {
    boolean existsPiloto(String name);
}
