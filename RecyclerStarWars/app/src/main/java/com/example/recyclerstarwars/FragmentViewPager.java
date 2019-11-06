package com.example.recyclerstarwars;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerstarwars.model.ContainerPeliculas;
import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.view.FragmentDetallePelicula;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPager extends Fragment {

    public static final String CLAVE_LISTA_PELICULAS = "CLAVE_LISTA_PELICULAS";

    public static final String CLAVE_POSICION = "CLAVE_POSICION";

    private ViewPager viewPager;


    public static FragmentViewPager dameUnFragment(ContainerPeliculas listaDePeliculas, Integer posicionSeleccionada){

        FragmentViewPager fragmentViewPager = new FragmentViewPager();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLAVE_LISTA_PELICULAS,listaDePeliculas);
        bundle.putInt(CLAVE_POSICION,posicionSeleccionada);
        fragmentViewPager.setArguments(bundle);

        return fragmentViewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaDelViewPager = inflater.inflate(R.layout.fragment_fragment_view_pager, container, false);

        viewPager = vistaDelViewPager.findViewById(R.id.ViewPager_Fragment);

        Bundle bundle = getArguments();

        ContainerPeliculas containerPeliculas = (ContainerPeliculas) bundle.getSerializable(CLAVE_LISTA_PELICULAS);

        Integer posicion = bundle.getInt(CLAVE_POSICION);

        AdapterViewPagerPeliculas adapterViewPagerPeliculas = new AdapterViewPagerPeliculas(getActivity().getSupportFragmentManager(),containerPeliculas.getListaDePeliculas());

        viewPager.setAdapter(adapterViewPagerPeliculas);

        viewPager.setCurrentItem(posicion);


        return vistaDelViewPager;
    }

}
