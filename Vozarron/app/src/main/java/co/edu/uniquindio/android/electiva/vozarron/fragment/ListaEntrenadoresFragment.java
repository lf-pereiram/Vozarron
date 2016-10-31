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
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaEntrenadoresFragment extends Fragment implements AdaptadorEntrenador.OnClickAdaptadorDeEntrenador{

    private RecyclerView listaEntrenadores;
    private ArrayList<Entrenador> entrenadores;
    private AdaptadorEntrenador adaptador;
    private OnEntrenadorSeleccionadoListener listener;

    public ListaEntrenadoresFragment() {
        // Required empty public constructor
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_entrenadores, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listaEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);

        adaptador = new AdaptadorEntrenador(entrenadores, this);
        listaEntrenadores.setAdapter(adaptador);
        listaEntrenadores.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        entrenadores = new ArrayList<>();

        entrenadores.add(new Entrenador(0,"Adele", "Pop", R.drawable.adele2, "Adele was born in North London, England, on May 5, 1988, " +
                "eventually attending the performing arts BRIT School. Her first two albums," +
                " 19 and 21, earned her critical praise and a level of commercial success " +
                "unsurpassed among her peers, with the artist selling millions of albums " +
                "worldwide and winning multiple Grammys. She also received a songwriting" +
                " Oscar for the James Bond track \"Skyfall.\" After becoming a mom, Adele" +
                " returned to the charts in autumn 2015 with the ballad \"Hello,\" the lead " +
                "single for her forthcoming album 25."));
        entrenadores.add(new Entrenador(1,"Rihanna", "Hip-Pop", R.drawable.rihanna2, "Robyn Rihanna Fenty (/riˈænə/;[2] born February 20, 1988)" +
                " is a Barbadian singer and songwriter. Born in Saint Michael and raised" +
                " in Bridgetown, she first entered the music industry by recording demo " +
                "tapes under the direction of record producer Evan Rogers in 2003." +
                " She ultimately signed a recording contract with Def Jam Recordings" +
                " after auditioning for its then-president, hip hop producer and rapper " +
                "Jay Z. In 2005, Rihanna rose to fame with the release of her debut studio " +
                "album Music of the Sun and its follow-up A Girl like Me (2006), which charted" +
                " on the top 10 of the U.S. Billboard 200 and respectively produced the hit" +
                " singles \"Pon de Replay\" and \"SOS\"."));
        entrenadores.add(new Entrenador(2, "Madonna", "Pop", R.drawable.madonna2, "Madonna Louise Ciccone (/tʃɪˈkoʊni/; born August 16, 1958) " +
                "is an American singer, songwriter, dancer, actress, and businesswoman. " +
                "She achieved popularity by pushing the boundaries of lyrical content in " +
                "mainstream popular music and imagery in her music videos, which became " +
                "a fixture on MTV. Madonna is known for reinventing both her music and image, " +
                "and for maintaining her autonomy within the recording industry. Music critics" +
                " have acclaimed her musical productions, which have generated some controversy." +
                " Referred to as the \"Queen of Pop\", Madonna is often cited as an influence by " +
                "other artists."));

        setEntrenadores(entrenadores);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }
        }
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }

    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
    }
}
