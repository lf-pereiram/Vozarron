package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class DetalleParticipanteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_participante);

        DetalleParticipanteFragment detalleParticipante = (DetalleParticipanteFragment)getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante);
        Participante participante = (Participante) getIntent().getExtras().get("participante");
        detalleParticipante.mostrarParticipante(participante);
    }
}
