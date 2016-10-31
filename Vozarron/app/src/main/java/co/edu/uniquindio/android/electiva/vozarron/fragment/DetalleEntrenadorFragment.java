package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleEntrenadorFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombre;
    private TextView txtHistorial;
    private ImageView foto;
    private Entrenador entrenador;


    public DetalleEntrenadorFragment() {
        // Required empty public constructor
    }

    public void mostrarEntrenador (Entrenador entrenador){
        this.entrenador = entrenador;
        txtNombre = (TextView) getView().findViewById(R.id.titulo_de_detalle_entrenador);
        txtNombre.setText(entrenador.getNombre());

        txtHistorial = (TextView) getView().findViewById(R.id.descripcion_de_detalle_entrenador);
        txtHistorial.setText(entrenador.getHistorial());

        foto = (ImageView) getView().findViewById(R.id.imagen_detalle);
        foto.setImageResource(entrenador.getFoto());

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_entrenador, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
