package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.AgregarParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

public class ParticipanteActivity extends AppCompatActivity implements ListaParticipantesFragment.OnParticipanteSeleccionadoListener {

    private ArrayList<Participante> participantes;
    ListaParticipantesFragment listaParticipantesFragment;

    public ParticipanteActivity(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ParticipanteActivity() {
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
        setContentView(R.layout.activity_participante);
        listaParticipantesFragment = (ListaParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);

        participantes = listaParticipantesFragment.getParticipantes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onParticipanteSeleccionado(int position) {
        Intent intent = new Intent(this, DetalleParticipanteActivity.class);
        intent.putExtra("participante", participantes.get(position));
        startActivity(intent);
    }

    /**
     * Permite mostrar un  mensaje en pantalla
     * @param mensaje mensaje que se desea actualizar
     */
    public static void mostrarMensaje(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void realizarVoto (View v) {
        TextView nombre = (TextView) findViewById(R.id.nombreParticipante);
        mostrarMensaje(ParticipanteActivity.this,"Se dio clic para votar por: " + nombre.getText());
        FloatingActionButton btnVotar = (FloatingActionButton) findViewById(R.id.btn_votar);
    }

    public void mostrarDialogoAgregarParticipante(String nombreClase) {
        AgregarParticipanteFragment dialogAgreParticipante = new AgregarParticipanteFragment();
        dialogAgreParticipante.setStyle(dialogAgreParticipante.STYLE_NORMAL, R.style.DialogoTitulo);
        dialogAgreParticipante.show(getSupportFragmentManager(), nombreClase);
    }

    public void agregarNuevoParticipante(View v){
        mostrarDialogoAgregarParticipante(ListaParticipantesFragment.class.getName());
        Toast.makeText(ParticipanteActivity.this, " Se hizo clic en boton agregar", Toast.LENGTH_LONG).show();
    }

}
