package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

public class EntrenadorActivity extends AppCompatActivity implements ListaEntrenadoresFragment.OnEntrenadorSeleccionadoListener{

    private ArrayList<Entrenador> entrenadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador);
        ListaEntrenadoresFragment listaEntrenadoresFragment = (ListaEntrenadoresFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_entrenadores);

        entrenadores = listaEntrenadoresFragment.getEntrenadores();
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
    public void onEntrenadorSeleccionado(int position) {
        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador) != null;
        if (esFragmento) {
            ((DetalleEntrenadorFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador)).mostrarEntrenador(entrenadores.get(position));
        } else {
            Intent intent = new Intent(this,
                    DetalleEntrenadorActivity.class);
            intent.putExtra("entrenador", entrenadores.get(position));
            startActivity(intent);
        }
    }
}
