package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.edu.uniquindio.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotacionFragment extends DialogFragment {


    public VotacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_votacion, container, false);

        Button fb = (Button) v.findViewById(R.id.btn_facebook);


        return v;
    }

}
