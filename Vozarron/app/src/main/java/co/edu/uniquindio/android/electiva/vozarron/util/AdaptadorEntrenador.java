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
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * Created by luisa on 28/10/2016.
 */

public class AdaptadorEntrenador extends RecyclerView.Adapter<AdaptadorEntrenador.EntrenadorViewHolder>{

    private ArrayList<Entrenador> entrenadores;
    private static OnClickAdaptadorDeEntrenador listener;

    public AdaptadorEntrenador(ArrayList<Entrenador> entrenadores, ListaEntrenadoresFragment listaEntrenadoresFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaEntrenadoresFragment;
    }

    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_entrenadores, parent, false);

        EntrenadorViewHolder entrenadorVH = new EntrenadorViewHolder(itemView);
        return entrenadorVH;
    }

    @Override
    public void onBindViewHolder(EntrenadorViewHolder holder, int position) {
        Entrenador entrenador = entrenadores.get(position);
        holder.bindEntrenador(entrenador);
    }

    @Override
    public int getItemCount() {
        return entrenadores.size();
    }

    public interface OnClickAdaptadorDeEntrenador {
        public void onClickPosition (int pos);
    }

    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreEntrenador;
        private TextView txtGenero;
        private ImageView fotoEntrenador;

        public EntrenadorViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            txtNombreEntrenador = (TextView) itemView.findViewById(R.id.nombreEntrenador);
            txtGenero = (TextView) itemView.findViewById(R.id.genero);
            fotoEntrenador = (ImageView) itemView.findViewById(R.id.fotoEntrenador);
        }

        public void bindEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());
            txtGenero.setText(entrenador.getGenero());
            fotoEntrenador.setImageResource(entrenador.getFoto());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+ txtNombreEntrenador.getText());
            listener.onClickPosition(getAdapterPosition());
        }
    }
}
