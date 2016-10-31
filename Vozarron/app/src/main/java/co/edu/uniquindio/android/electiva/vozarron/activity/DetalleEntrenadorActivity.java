package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

public class DetalleEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);

        DetalleEntrenadorFragment detalleEntrenador = (DetalleEntrenadorFragment)getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador);
        Entrenador entrenador = (Entrenador) getIntent().getExtras().get("entrenador");
        detalleEntrenador.mostrarEntrenador(entrenador);
    }
}
