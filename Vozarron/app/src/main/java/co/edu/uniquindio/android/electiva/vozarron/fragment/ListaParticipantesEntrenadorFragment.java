package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorParticipanteEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaParticipantesEntrenadorFragment extends Fragment implements AdaptadorParticipanteEntrenador.OnClickAdaptadorDePersonajeEntrenador{

    private AdaptadorParticipanteEntrenador adaptador;
    private RecyclerView listadoParticipantesEntrenador;
    private ArrayList<Participante> participantes;
    private OnParticipanteSeleccionadoListener listener;

    public ListaParticipantesEntrenadorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onParticipanteSeleccionado(pos);
    }

    public interface OnParticipanteSeleccionadoListener {
        void onParticipanteSeleccionado(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_participantes_entrenador, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoParticipantesEntrenador = (RecyclerView)getView().findViewById(R.id.listaParticipantesEntrenador);

        adaptador = new AdaptadorParticipanteEntrenador(participantes, this);
        listadoParticipantesEntrenador.setAdapter(adaptador);

        listadoParticipantesEntrenador.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnParticipanteSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }
        }
    }
}
