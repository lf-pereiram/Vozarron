package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class DetalleParticipanteEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_participante_entrenador);

        DetalleParticipanteEntrenadorFragment detalleParticipante = (DetalleParticipanteEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante_entrenador);
        Participante participante = (Participante) getIntent().getExtras().get("particapanteE");
        detalleParticipante.mostrarParticipante(participante);
    }
}
