package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
