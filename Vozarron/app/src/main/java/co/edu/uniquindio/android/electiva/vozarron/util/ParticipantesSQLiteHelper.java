package co.edu.uniquindio.android.electiva.vozarron.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luisa on 22/11/2016.
 */

public class ParticipantesSQLiteHelper extends SQLiteOpenHelper {
    public ParticipantesSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConexionSQLite.crearTabla());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
