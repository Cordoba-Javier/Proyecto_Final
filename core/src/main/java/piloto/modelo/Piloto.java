package piloto.modelo;

import piloto.exception.ExceptionPiloto;

import java.util.UUID;

public class Piloto {
    private UUID idPiloto;
    private String name;
    private String surname;
    private String full_name;
    private String short_name;
    private String picture_uri;

    private Piloto(UUID id, String name, String surname, String full_name, String short_name, String picture_uri) {
        this.idPiloto = id;
        this.name = name;
        this.surname = surname;
        this.full_name = full_name;
        this.short_name = short_name;
        this.picture_uri = picture_uri;
    }

    public static Piloto factory(UUID id, String name, String surname, String full_name, String short_name, String picture_uri) throws ExceptionPiloto{
        if(id==null)
            throw new ExceptionPiloto("Piloto id null");
        if(name==null|| name.isEmpty())
            throw new ExceptionPiloto("Piloto name null o vacio");
        if(surname==null||surname.isEmpty())
            throw new ExceptionPiloto("Piloto surname null o vacio");
        if (full_name==null||full_name.isEmpty())
            throw new ExceptionPiloto("Piloto full_name null o vacio");
        if (short_name==null||short_name.isEmpty())
            throw new ExceptionPiloto("Piloto short name null o vacio");
        if (picture_uri==null||picture_uri.isEmpty())
            throw new ExceptionPiloto("Piloto picture_uri null o vacio");
        return new Piloto(id, name, surname, full_name, short_name, picture_uri);
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
