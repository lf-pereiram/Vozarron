package co.edu.uniquindio.android.electiva.vozarron.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luisa on 28/10/2016.
 */

public class Participante implements Parcelable {

    private int id;
    private String nombre;
    private int foto;
    private int edad;
    private int entrenador;
    private int rol;
    private int numVotos;
    private String urlVideo;
    private boolean estado;

    public Participante(int id, String nombre, int foto, int edad, int entrenador, int rol, int numVotos, String urlVideo, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
        this.entrenador = entrenador;
        this.rol = rol;
        this.numVotos = numVotos;
        this.urlVideo = urlVideo;
        this.estado = estado;
    }

    protected Participante(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        foto = in.readInt();
        edad = in.readInt();
        entrenador = in.readInt();
        rol = in.readInt();
        numVotos = in.readInt();
        urlVideo = in.readString();
        estado = in.readByte() != 0;
    }

    public static final Creator<Participante> CREATOR = new Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel in) {
            return new Participante(in);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(int entrenador) {
        this.entrenador = entrenador;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeInt(foto);
        dest.writeInt(edad);
        dest.writeInt(entrenador);
        dest.writeInt(rol);
        dest.writeInt(numVotos);
        dest.writeString(urlVideo);
        dest.writeByte((byte) (estado ? 1 : 0));
    }

    public String rolToString (int rol){

        String rolString;

        switch (rol){
            case 0: rolString = "Estudiante";
                break;
            case 1: rolString = "Profesor";
                break;
            case 2: rolString = "Administrativo";
                break;
            case 3: rolString = "Egresado";
                break;
            default: rolString = "No se ha seleccionado un rol";
                break;
        }

        return rolString;
    }

    public String idEntrenadorToString (int rol){

        String idString;

        switch (rol){
            case 0: idString = "Adele";
                break;
            case 1: idString = "Rihanna";
                break;
            case 2: idString = "Madonna";
                break;
            default: idString = "No se ha seleccionado un rol";
                break;
        }

        return idString;
    }
}
