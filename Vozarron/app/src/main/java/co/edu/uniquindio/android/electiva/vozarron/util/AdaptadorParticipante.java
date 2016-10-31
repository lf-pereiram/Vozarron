package co.edu.uniquindio.android.electiva.vozarron.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * Created by luisa on 29/10/2016.
 */

public class AdaptadorParticipante extends RecyclerView.Adapter<AdaptadorParticipante.ParticipanteViewHolder> {

    private ArrayList<Participante> participantes;
    private static OnClickAdaptadorDeParticipante listener;

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
        Participante participante = participantes.get(position);
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

        public ParticipanteViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            txtNombreParticipante = (TextView) itemView.findViewById(R.id.nombreParticipante);
            txtRol = (TextView) itemView.findViewById(R.id.rol);
            fotoParticipante = (ImageView) itemView.findViewById(R.id.fotoParticipante);
        }

        public void bindParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());
            txtRol.setText(participante.rolToString(participante.getRol()));
            fotoParticipante.setImageResource(participante.getFoto());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombreParticipante.getText());
            listener.onClickPosition(getAdapterPosition());
        }
    }
}
