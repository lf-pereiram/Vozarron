package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleParticipanteEntrenadorFragment extends Fragment implements View.OnClickListener{

    private TextView txtNombre;
    private TextView txtEdad;
    private TextView txtEntrenador;
    private TextView txtRol;
    private Button urlVideo;
    private ImageView foto;
    private Participante participante;

    public DetalleParticipanteEntrenadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_participante_entrenador, container, false);
    }

    public void mostrarParticipante (Participante participante){
        this.participante = participante;
        txtNombre = (TextView) getView().findViewById(R.id.titulo_de_detalle_participante2);
        txtNombre.setText(participante.getNombre());

        txtEdad = (TextView) getView().findViewById(R.id.edad_de_detalle_participante2);
        txtEdad.setText(Integer.toString(participante.getEdad()));

        txtEntrenador = (TextView) getView().findViewById(R.id.entrenador_de_detalle_participante2);
        txtEntrenador.setText(participante.idEntrenadorToString(participante.getEntrenador()));

        txtRol = (TextView) getView().findViewById(R.id.rol_de_detalle_participante2);
        txtRol.setText(participante.rolToString(participante.getRol()));

        foto = (ImageView) getView().findViewById(R.id.imagen_detalle2);
        foto.setImageResource(participante.getFoto());

        urlVideo = (Button) getView().findViewById(R.id.btn_url2);
        urlVideo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
