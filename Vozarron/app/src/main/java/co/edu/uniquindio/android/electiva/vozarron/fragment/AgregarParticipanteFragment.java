package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Participante;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarParticipanteFragment extends DialogFragment {

    private ListaParticipantesFragment participantesFragment;
    private EditText campoNombre, campoEdad, campoUrl;
    private Spinner campoEntrenador, campoRol;
    private String nombre, url, edad;
    private int rol, entrenador;
    private ArrayList<Participante> participantes;
    private ImageView foto;

    //  id que se le asigna a la imagen
    private static final int RESULT_IMAGE = 1;

    public AgregarParticipanteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getDialog().setTitle("Nuevo Participante");//cargue el texto desde los recursos

        View v =  inflater.inflate(R.layout.fragment_agregar_participante, null);

        campoNombre = (EditText) v.findViewById(R.id.nuevo_nombre);
        campoEdad = (EditText) v.findViewById(R.id.nuevo_edad);
        campoRol = (Spinner) v.findViewById(R.id.nuevo_rol);
        campoEntrenador = (Spinner) v.findViewById(R.id.nuevo_entrenador);
        campoUrl = (EditText) v.findViewById(R.id.nuevo_url);

        // ------------------ Spinner para la seleccion del rol
        Spinner nuevoRol = (Spinner) v.findViewById(R.id.nuevo_rol);

        //Se inicializa el adaptador para que reciva el arreglo del archivo personalidades
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.roles, android.R.layout.simple_spinner_item);

        //Indica la apariencia que se desea tener al momento de desplegar el Spinner
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Se asigna al <<Spinner>> el adaptador creado previamente
        nuevoRol.setAdapter(adaptador);

        //En el momento de seleccionar un elemento se muestra un mensaje con el texto del elemento
        nuevoRol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            //Si se selecciona un elemento vacio se muestra el mensaje
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), " Vacio ", Toast.LENGTH_LONG).show();
            }
        });

        // ------------------ Spinner para la seleccion del entrenador
        Spinner nuevoEntrenador = (Spinner) v.findViewById(R.id.nuevo_entrenador);

        //Se inicializa el adaptador para que reciva el arreglo del archivo personalidades
        ArrayAdapter<CharSequence> adaptadorEntrenado = ArrayAdapter.createFromResource(getActivity(), R.array.entrenadores, android.R.layout.simple_spinner_item);

        //Indica la apariencia que se desea tener al momento de desplegar el Spinner
        adaptadorEntrenado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Se asigna al <<Spinner>> el adaptador creado previamente
        nuevoEntrenador.setAdapter(adaptadorEntrenado);

        //En el momento de seleccionar un elemento se muestra un mensaje con el texto del elemento
        nuevoEntrenador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

                Toast.makeText(getActivity(), " " + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }

            //Si se selecciona un elemento vacio se muestra el mensaje
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), " Vacio ", Toast.LENGTH_LONG).show();
            }
        });

        Button nuevoParticipante = (Button) v.findViewById(R.id.btn_agregar);
        nuevoParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participantes = ListaParticipantesFragment.participantes;
                Participante nuevo;

                nombre = campoNombre.getText().toString();
                edad = campoEdad.getText().toString();
                rol = campoRol.getSelectedItemPosition();
                entrenador = campoEntrenador.getSelectedItemPosition();
                url = campoUrl.getText().toString();

                if(participantes != null){
                    nuevo = new Participante(participantes.size()+1, nombre, R.drawable.nueva_persona, Integer.parseInt(edad), entrenador, rol, 0, url, true);
                }else {
                    nuevo = new Participante(0, nombre, R.drawable.nueva_persona, Integer.parseInt(edad), entrenador, rol, 0, url, true);
                }
                ListaParticipantesFragment.participantes.add(nuevo);
                ListaParticipantesFragment.adaptador.notifyDataSetChanged();

                getDialog().dismiss();

                Toast.makeText(getActivity(), "Participante: " + nombre + " agregado(a)", Toast.LENGTH_LONG).show();
            }
        });

        foto = (ImageView) v.findViewById(R.id.nuevo_foto);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Permite abrir la galeria de imagenes para el usuario pueda seleccionar una imagen
                Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Inicia la actividad para que cuando un usuario seleccione la imagen se pueda trabajar con ella
                startActivityForResult(galeria, RESULT_IMAGE);
            }
        });
        return v;
    }

    // Sobre-escribe el metodo que es llamado al dar clic para cargar una nueva imagen
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_IMAGE && resultCode == Activity.RESULT_OK && data != null){
            Uri imagenSeleccionada = data.getData();
            foto.setImageURI(imagenSeleccionada);
        }
    }
}
