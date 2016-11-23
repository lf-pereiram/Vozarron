package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorParticipante;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorParticipanteEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class ParticipanteEntrenadorActivity extends AppCompatActivity implements ListaParticipantesEntrenadorFragment.OnParticipanteSeleccionadoListener {

    private ArrayList<Participante> participantes;
    ListaParticipantesFragment listaParticipantesFragment;

    public ParticipanteEntrenadorActivity(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ParticipanteEntrenadorActivity() {
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_entrenador);

        // ListaParticipantesEntrenadorFragment listaParticipantesEFragment = (ListaParticipantesEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participante_entrenador);
        listaParticipantesFragment = (ListaParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);

        participantes = listaParticipantesFragment.getParticipantes();

    }

    @Override
    public void onParticipanteSeleccionado(int position) {
        boolean esFragment = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante_entrenador) != null;

        if(esFragment){
            ((DetalleParticipanteEntrenadorFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante_entrenador)).mostrarParticipante(participantes.get(position));
        } else{
            Intent intent = new Intent(this, DetalleParticipanteEntrenadorActivity.class);
            intent.putExtra("participanteE", participantes.get(position));
            startActivity(intent);
        }
    }
}
