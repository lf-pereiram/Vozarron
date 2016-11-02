package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.AgregarParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * Created by luisa on 1/11/2016.
 */

public class ParticipantesEntrenadorActivity extends AppCompatActivity implements ListaParticipantesFragment.OnParticipanteSeleccionadoListener{
    private ArrayList<Participante> participantes;
    ListaParticipantesFragment listaParticipantesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);

        int id = (int) getIntent().getExtras().get("id_entrenador");

        listaParticipantesFragment = (ListaParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);

        participantes = listaParticipantesFragment.listarParticipantesPorEntrenador(id);
        Log.v("Lista", ""+participantes.size());
    }

    @Override
    public void onParticipanteSeleccionado(int position) {

        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante) != null;
        if (esFragmento) {
            ((DetalleParticipanteFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_participante))
                    .mostrarParticipante(participantes.get(position));
        } else {
            Intent intent = new Intent(this,
                    DetalleParticipanteActivity.class);
            intent.putExtra("participante", participantes.get(position));
            startActivity(intent);
        }
    }

    /**
     * Permite mostrar un  mensaje en pantalla
     * @param mensaje mensaje que se desea actualizar
     */
    public static void mostrarMensaje(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void mostrarDialogoAgregarParticipante(String nombreClase) {
        AgregarParticipanteFragment dialogAgreParticipante = new AgregarParticipanteFragment();
        dialogAgreParticipante.setStyle(dialogAgreParticipante.STYLE_NORMAL, R.style.DialogoTitulo);
        dialogAgreParticipante.show(getSupportFragmentManager(), nombreClase);
    }

    public void agregarNuevoParticipante(View v){
        mostrarDialogoAgregarParticipante(ListaParticipantesFragment.class.getName());
    }
}
