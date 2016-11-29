package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * Created by Manuel on 22/11/2016.
 */

public class Utilidades {

    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";
    public final static String URL_SERVICIO = "http://10.0.2.2:3000/api/manager";
    public static final int LISTAR = 1;
    public static final int AGREGAR = 2;
    public static final int MODIFICAR = 3;
    public static final int ELIMINAR = 4;


    public static void cambiarIdioma(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);

        if (language.equals(LENGUAJE_ES)) {
            language = LENGUAJE_EN;
        } else if (language.equals(LENGUAJE_EN)) {
            language = LENGUAJE_ES;
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();

        obtenerLenguaje(context);
    }

    public static void obtenerLenguaje(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }

   public static Participante convertirJSONAParticipante(String jsonParticipante) {
        Gson gson = new Gson();
        Participante participante = gson.fromJson(jsonParticipante, Participante.class);
        Log.v("JSON-Participante", " participantes: "+participante);
        return participante;
    }

    public static String convertirPersonajeAJSON(Participante participante) {
        Gson gson = new Gson();
        String json = gson.toJson(participante);
        return json;
    }

}
