package ar.edu.undec.adapter.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import piloto.input.MostrarPilotos;
import piloto.modelo.Piloto;

import java.util.List;

@Repository
public class MostrarPilotosControl {
    private MostrarPilotos mostrar;

    @Autowired
    public MostrarPilotosControl(MostrarPilotos mostrar) {
        this.mostrar = mostrar;
    }

    @GetMapping
    public ResponseEntity<List<Piloto>> mostrarPilotos() {
        return ResponseEntity.ok(mostrar.getPilotos());
    }
}
