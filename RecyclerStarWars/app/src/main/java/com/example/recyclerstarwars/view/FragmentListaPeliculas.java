package com.example.recyclerstarwars.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.controller.PeliculaController;
import com.example.recyclerstarwars.model.Pelicula;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaPeliculas extends Fragment implements AdapterPeliculas.InterfazListenerPosicion{


    private RecyclerView recyclerView;
    private FragmentListener fragmentListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        fragmentListener = (FragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);

        //encontrar el recycler
        recyclerView = view.findViewById(R.id.fragmentPeliculas_recycler);
        //crear el adapter
        PeliculaController peliculaController = new PeliculaController();
        List<Pelicula> peliculasDeLaLista = peliculaController.traerPeliculas();
        AdapterPeliculas adapterPeliculas = new AdapterPeliculas(peliculasDeLaLista, this);
        //setearle el layout manager (
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //setearle el adapter
        recyclerView.setAdapter(adapterPeliculas);



        return view;
    }



    @Override
    public void interfazListenerPosicion(List<Pelicula> listaDePeliculas, Integer posicion) {
        fragmentListener.fragmentListener(listaDePeliculas, posicion);
    }

    public interface FragmentListener{
        public void fragmentListener(List<Pelicula> listaDePeliculas, Integer posicion);
    }

}
