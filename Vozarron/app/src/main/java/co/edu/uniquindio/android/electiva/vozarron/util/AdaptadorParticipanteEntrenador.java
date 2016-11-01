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
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaParticipantesEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * Created by luisa on 31/10/2016.
 */

public class AdaptadorParticipanteEntrenador  extends RecyclerView.Adapter<AdaptadorParticipanteEntrenador.ParticipanteEntrenadorViewHolder>{

    private ArrayList<Participante> participantes;
    private static OnClickAdaptadorDePersonajeEntrenador listener;

    public AdaptadorParticipanteEntrenador(ArrayList<Participante> participantes, ListaParticipantesEntrenadorFragment listaParticipantesEntrenadorFragment) {
        this.participantes = participantes;
        listener = (OnClickAdaptadorDePersonajeEntrenador) listaParticipantesEntrenadorFragment;
    }

    public interface OnClickAdaptadorDePersonajeEntrenador{
        public void onClickPosition(int pos);
    }

    @Override
    public ParticipanteEntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_participantes_entrenador, parent, false);

        ParticipanteEntrenadorViewHolder peVH = new ParticipanteEntrenadorViewHolder(itemView);
        return peVH;
    }

    @Override
    public void onBindViewHolder(ParticipanteEntrenadorViewHolder holder, int position) {
        Participante participante = participantes.get(position);
        holder.bindParticipanteEntrenador(participante);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    public static class ParticipanteEntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtNombreParticipante;
        private TextView txtRol;
        private ImageView fotoParticipante;

        public ParticipanteEntrenadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreParticipante = (TextView) itemView.findViewById(R.id.nombreParticipanteE);
            txtRol = (TextView) itemView.findViewById(R.id.rolE);
            fotoParticipante = (ImageView) itemView.findViewById(R.id.fotoParticipanteE);
        }

        public void bindParticipanteEntrenador(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());
            txtRol.setText(participante.rolToString(participante.getRol()));
            fotoParticipante.setImageResource(participante.getFoto());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+
                    txtNombreParticipante.getText());
            listener.onClickPosition(getAdapterPosition());
        }
    }
}
