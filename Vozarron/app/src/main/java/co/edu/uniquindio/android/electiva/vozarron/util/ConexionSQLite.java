package co.edu.uniquindio.android.electiva.vozarron.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by luisa on 22/11/2016.
 */

public class ConexionSQLite {

    public static final String NOMBRE_BD = "Personajes";
    public static final String NOMBRE_TABLA = "Personaje";
    public static final String CAMPOS_TABLA[] = new String[]{"_ID","NOMBRE", "FOTO", "EDAD", "ENTRENADOR_ID", "ROL", "NUM_VOTOS", "ESTAD0", "URL"};

    private ParticipantesSQLiteHelper usdbh;
    private SQLiteDatabase db;

    public ConexionSQLite(Context context, int version) {
        usdbh = new ParticipantesSQLiteHelper(context, NOMBRE_BD , null, version);
        db = usdbh.getWritableDatabase();
    }

    public static String crearTabla(){
        String crearTabla = "CREATE TABLE %s ( ? INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)";
        return String.format(crearTabla, NOMBRE_TABLA, CAMPOS_TABLA[0], CAMPOS_TABLA[1], CAMPOS_TABLA[2], CAMPOS_TABLA[3], CAMPOS_TABLA[4], CAMPOS_TABLA[5], CAMPOS_TABLA[6], CAMPOS_TABLA[7], CAMPOS_TABLA[8]);
    }

}
