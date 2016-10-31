package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleParticipanteFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombre;
    private TextView txtEdad;
    private TextView txtEntrenador;
    private TextView txtRol;
    private Button urlVideo;
    private ImageView foto;
    private Participante participante;


    public DetalleParticipanteFragment() {
        // Required empty public constructor
    }

    public void mostrarParticipante (Participante participante){
        this.participante = participante;
        txtNombre = (TextView) getView().findViewById(R.id.titulo_de_detalle_participante);
        txtNombre.setText(participante.getNombre());

        txtEdad = (TextView) getView().findViewById(R.id.edad_de_detalle_participante);
        txtEdad.setText(Integer.toString(participante.getEdad()));

        txtEntrenador = (TextView) getView().findViewById(R.id.entrenador_de_detalle_participante);
        txtEntrenador.setText(participante.idEntrenadorToString(participante.getEntrenador()));

        txtRol = (TextView) getView().findViewById(R.id.rol_de_detalle_participante);
        txtRol.setText(participante.rolToString(participante.getRol()));

        foto = (ImageView) getView().findViewById(R.id.imagen_detalle);
        foto.setImageResource(participante.getFoto());

        urlVideo = (Button) getView().findViewById(R.id.btn_url);
        urlVideo.setOnClickListener(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_participante, container, false);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(participante.getUrlVideo()));
        startActivity(intent);
    }
}
