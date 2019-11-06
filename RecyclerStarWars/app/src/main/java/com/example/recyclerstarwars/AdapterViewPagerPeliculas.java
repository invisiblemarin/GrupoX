package com.example.recyclerstarwars;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.view.FragmentDetallePelicula;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPagerPeliculas extends FragmentStatePagerAdapter {

        private List<FragmentDetallePelicula> listaDeFragments;



        public AdapterViewPagerPeliculas(FragmentManager fm, List<Pelicula> peliculaAMostrar) {
            super(fm);

            listaDeFragments = new ArrayList<>();

            for (Pelicula pelicula: peliculaAMostrar) {
                FragmentDetallePelicula fragment = FragmentDetallePelicula.dameUnFragment(pelicula);
                listaDeFragments.add(fragment);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return listaDeFragments.get(position);
        }

        @Override
        public int getCount() {
            return listaDeFragments.size();
        }
    }
