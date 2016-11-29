package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uniquindio.android.electiva.vozarron.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_principal);
    }

    public void verEntrenadores (View view) {
        Intent intent = new Intent(this, EntrenadorActivity.class);
        startActivity(intent);
    }

    public void verParticipantes (View view) {
        Intent intent = new Intent(this, ParticipanteActivity.class);
        startActivity(intent);
    }
    public void cambiarIdioma(View view){
        Utilidades.cambiarIdioma(this);
        Intent intent = this.getIntent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        this.finish();
        startActivity(intent);

    }
}
