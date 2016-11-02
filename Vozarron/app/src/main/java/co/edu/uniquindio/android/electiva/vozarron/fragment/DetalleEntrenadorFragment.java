package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.activity.EntrenadorActivity;
import co.edu.uniquindio.android.electiva.vozarron.activity.ParticipanteActivity;
import co.edu.uniquindio.android.electiva.vozarron.activity.ParticipanteEntrenadorActivity;
import co.edu.uniquindio.android.electiva.vozarron.activity.ParticipantesEntrenadorActivity;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleEntrenadorFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombre;
    private TextView txtHistorial;
    private ImageView foto;
    private Entrenador entrenador;
    private Button btnLista;
    private int id;


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

        id = entrenador.getId();
        Log.v("Id_entre:", "------"+id);

        btnLista = (Button) getView().findViewById(R.id.btn_participantes);
        btnLista.setOnClickListener(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_entrenador, container, false);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ParticipantesEntrenadorActivity.class);
        intent.putExtra("id_entrenador", id);
        startActivity(intent);
    }
}
