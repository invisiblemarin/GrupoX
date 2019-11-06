package com.example.recyclerstarwars.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.model.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePelicula extends Fragment {


    public static final String CLAVE_DETALLE = "CLAVE_DETALLE";

    private TextView textViewTitulo;
    private TextView textViewDirector;
    private TextView textViewFecha;
    private TextView textViewSinopsis;

    private ImageView imageViewPoster;


    public static FragmentDetallePelicula dameUnFragment(Pelicula pelicula){

        FragmentDetallePelicula fragmentDetallePelicula = new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLAVE_DETALLE,pelicula);
        fragmentDetallePelicula.setArguments(bundle);

        return fragmentDetallePelicula;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaDelFragment = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);


        //encontrar la vista

        textViewTitulo = vistaDelFragment.findViewById(R.id.TextView_Titulo);
        textViewDirector = vistaDelFragment.findViewById(R.id.TextView_Director);
        textViewFecha = vistaDelFragment.findViewById(R.id.TextView_Fecha);
        textViewSinopsis = vistaDelFragment.findViewById(R.id.TextView_Sinopsis);
        imageViewPoster = vistaDelFragment.findViewById(R.id.ImageView_Poster);
        //agarrar el bundle

        Bundle bundle = getArguments();
        //agarrar la pelicula del bundle

        Pelicula pelicula = (Pelicula) bundle.getSerializable(CLAVE_DETALLE);
        //cargar la pelicula en las vistas
        textViewTitulo.setText(pelicula.getTitulo());
        textViewDirector.setText(pelicula.getDirector());
        textViewFecha.setText(pelicula.getFechaEstreno());
        textViewSinopsis.setText(pelicula.getSinopsis());

        Glide.with(getContext())
                .load(pelicula.getUrlImagen())
                .into(imageViewPoster);

        return vistaDelFragment;
    }

}
