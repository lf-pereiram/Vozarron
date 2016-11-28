package co.edu.uniquindio.android.electiva.vozarron.util;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.activity.DetalleParticipanteActivity;
import co.edu.uniquindio.android.electiva.vozarron.activity.ParticipanteActivity;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleParticipanteFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * Created by luisa on 29/10/2016.
 */

public class AdaptadorParticipante extends RecyclerView.Adapter<AdaptadorParticipante.ParticipanteViewHolder> {

    private static ArrayList<Participante> participantes;
    private static OnClickAdaptadorDeParticipante listener;
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }

    public AdaptadorParticipante(ArrayList<Participante> participantes, ListaParticipantesFragment listaParticipantesFragment) {
        this.participantes = participantes;
        listener = (OnClickAdaptadorDeParticipante) listaParticipantesFragment;
    }

    @Override
    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_participantes, parent, false);

        ParticipanteViewHolder participanteVH = new ParticipanteViewHolder(itemView);
        return participanteVH;
    }

    @Override
    public void onBindViewHolder(ParticipanteViewHolder holder, int position) {
        participante = participantes.get(position);
        holder.bindParticipante(participante);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    public interface OnClickAdaptadorDeParticipante {
        public void onClickPosition (int pos);
    }

    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtNombreParticipante;
        private TextView txtRol;
        private ImageView fotoParticipante;
        private TextView txtNumeroVotos;
        private FloatingActionButton btnVotar;
        private FloatingActionButton btnVer;
        private Participante p;

        public ParticipanteViewHolder(View itemView) {
            super(itemView);

            txtNombreParticipante = (TextView) itemView.findViewById(R.id.nombreParticipante);
            txtRol = (TextView) itemView.findViewById(R.id.rol);
            fotoParticipante = (ImageView) itemView.findViewById(R.id.fotoParticipante);
            txtNumeroVotos = (TextView) itemView.findViewById(R.id.numVotos);

            btnVotar= (FloatingActionButton) itemView.findViewById(R.id.btn_votar);
            btnVotar.setOnClickListener(this);

            btnVer = (FloatingActionButton) itemView.findViewById(R.id.btn_ver);
            btnVer.setOnClickListener(this);
        }

        public void bindParticipante(Participante participante) {

            txtNombreParticipante.setText(participante.getNombre());
            txtRol.setText(participante.rolToString(participante.getRol()));
            fotoParticipante.setImageResource(participante.getFoto());
            txtNumeroVotos.setText(Integer.toString(participante.getNumVotos()));

            p = participante;
        }

        public Participante realizarVotos (){
            int votos = p.getNumVotos()+1;
            p.setNumVotos(votos);

            return p;
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == btnVer.getId()){
                listener.onClickPosition(getAdapterPosition());
            }

            if(v.getId() == btnVotar.getId()){

                int votos = p.getNumVotos()+1;
                p.setNumVotos(votos);
                txtNumeroVotos.setText(Integer.toString(p.getNumVotos()));
                participantes.add(p);
            }

        }
    }
}
