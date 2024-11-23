package ar.edu.undec.adapter.data.entityData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import piloto.modelo.Piloto;


import java.util.UUID;
@Entity(name="piloto")
public class PilotoEntityData {
    @Id
    private UUID idPiloto;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="full_name")
    private String full_name;
    @Column(name="short_name")
    private String short_name;
    @Column(name="picture_uri")
    private String picture_uri;

    public PilotoEntityData(){}

    public PilotoEntityData( UUID id, String name, String surname, String full_name, String short_name, String picture_uri){
        this.idPiloto = id;
        this.name = name;
        this.surname = surname;
        this.full_name = full_name;
        this.short_name = short_name;
        this.picture_uri = picture_uri;
    }

    public static PilotoEntityData crearEntityData(Piloto piloto){
        return new PilotoEntityData(piloto.getIdPiloto(),piloto.getName(),piloto.getSurname(),piloto.getFull_name(),piloto.getShort_name(),piloto.getPicture_uri());
    }

    public UUID getIdPiloto() {
        return idPiloto;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public String getPicture_uri() {
        return picture_uri;
    }

}
