package ar.edu.undec.adapter.service.controller;

import ar.edu.undec.adapter.service.entityDTO.PilotoEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import piloto.input.CrearPiloto;

@RestController
@RequestMapping("piloto")
public class CrearPilotoControl {
    private CrearPiloto crear;

    @Autowired
    public CrearPilotoControl(CrearPiloto crearPiloto) {
        this.crear = crearPiloto;
    }

    @PostMapping
    public ResponseEntity<?> crearPiloto(@RequestBody PilotoEntityDTO pilotoDTO) {
        try{
            crear.crearPiloto(pilotoDTO.getName(),
                    pilotoDTO.getSurname(),
                    pilotoDTO.getFull_name(),
                    pilotoDTO.getShort_name(),
                    pilotoDTO.getPicture_uri());
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().body("No se pudo crear el piloto");
        }
    }
}
