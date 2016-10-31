package co.edu.uniquindio.android.electiva.vozarron.vo;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by luisa on 28/10/2016.
 */

public class Entrenador implements Parcelable {

    private int id;
    private String nombre;
    private String genero;
    private String historial;
    private int foto;
    private ArrayList<Participante> participantes;

    public Entrenador(int id, String nombre, String genero, int foto, String historial) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.foto = foto;
        this.historial = historial;
    }

    public Entrenador(int id, String nombre, String genero, String historial, int foto, ArrayList<Participante> participantes) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.historial = historial;
        this.foto = foto;
        this.participantes = participantes;
    }

    protected Entrenador(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        genero = in.readString();
        historial = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Entrenador> CREATOR = new Creator<Entrenador>() {
        @Override
        public Entrenador createFromParcel(Parcel in) {
            return new Entrenador(in);
        }

        @Override
        public Entrenador[] newArray(int size) {
            return new Entrenador[size];
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(genero);
        dest.writeString(historial);
        dest.writeInt(foto);
    }
}
