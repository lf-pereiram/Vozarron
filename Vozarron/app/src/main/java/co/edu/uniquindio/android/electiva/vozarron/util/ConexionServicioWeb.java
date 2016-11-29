package co.edu.uniquindio.android.electiva.vozarron.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.activity.Utilidades;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by luisa on 28/11/2016.
 */

public class ConexionServicioWeb {

    public static ArrayList<Participante> getListaParticipantes() {
        ArrayList<Participante> participantes;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(Utilidades.URL_SERVICIO);
        request.setHeader("content-type", "application/json");

        try {
            Type listType = new TypeToken<ArrayList<Participante>>() {
            }.getType();
            GsonBuilder gsonBuilder = new GsonBuilder();


            HttpResponse resp = httpClient.execute(request);
            String respStr = EntityUtils.toString(resp.getEntity());
            Log.v("Listar-WParticipantes", "participantes ... " + respStr);
            Gson gson = gsonBuilder.create();
            participantes = gson.fromJson(respStr, listType);
            Log.v("Listar-WParticipantes", "participantes ... " + participantes.size());

        } catch (Exception e) {
            e.printStackTrace();
            Log.v("Listar-WebService", e.getMessage());
            return null;
        }
        return participantes;
    }

    /*public static Participante agregarParticipanteAlServicio(String
                                                                     jsonParticipante) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(Utilidades.URL_SERVICIO);
        post.setHeader("content-type", "application/json");
        Log.v("json", "json " + jsonParticipante);
        Participante participante = null;
        try {
            StringEntity entity = new StringEntity(jsonParticipante);
            post.setEntity(entity);
            HttpResponse respose = httpClient.execute(post);
            String resp = EntityUtils.toString(respose.getEntity());
            participante = Utilidades.convertirJSONAParticipante(resp);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ServicioRest", "Error! insercion de personaje " +
                    e.getMessage());
            return null;
        }
        return participante;
    }*/
}
