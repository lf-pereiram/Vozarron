package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorParticipante;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorParticipanteEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class ParticipanteEntrenadorActivity extends AppCompatActivity implements ListaParticipantesEntrenadorFragment.OnParticipanteSeleccionadoListener {

    private ArrayList<Participante> participantes;
    private ListaParticipantesFragment listaParticipantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_entrenador);

        participantes = new ArrayList<Participante>();
        listaParticipantes = new ListaParticipantesFragment();

        participantes = listaParticipantes.cargarListaParticipantes();
    }

    @Override
    public void onParticipanteSeleccionado(int position) {

    }
}
