package ar.edu.undec.adapter.service.entityDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PilotoEntityDTO {
    @JsonProperty("idPiloto")
    private UUID idPiloto;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("full_name")
    private String full_name;
    @JsonProperty("short_name")
    private String short_name;
    @JsonProperty("picture_uri")
    private String picture_uri;

    public PilotoEntityDTO(){}
    public PilotoEntityDTO(UUID id, String name, String surname, String full_name, String short_name, String picture_uri) {
        this.idPiloto = id;
        this.name = name;
        this.surname = surname;
        this.full_name = full_name;
        this.short_name = short_name;
        this.picture_uri = picture_uri;
    }

    public static PilotoEntityDTO crearPilotoDTO(UUID id, String name, String surname, String full_name, String short_name, String picture_uri) {
        return new PilotoEntityDTO(id, name, surname, full_name, short_name, picture_uri);
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
