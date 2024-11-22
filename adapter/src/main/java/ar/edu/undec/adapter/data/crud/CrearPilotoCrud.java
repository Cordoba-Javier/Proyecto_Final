package ar.edu.undec.adapter.data.crud;

import ar.edu.undec.adapter.data.entityData.PilotoEntityData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CrearPilotoCrud extends CrudRepository<PilotoEntityData, UUID> {
    boolean existsPiloto(String name);
}
