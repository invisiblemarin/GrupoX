package com.example.recyclerstarwars.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.recyclerstarwars.AdapterViewPagerPeliculas;
import com.example.recyclerstarwars.FragmentViewPager;
import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.model.ContainerPeliculas;
import com.example.recyclerstarwars.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentListaPeliculas.FragmentListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentListaPeliculas());



    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_container,fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void fragmentListener(List<Pelicula> listaDePeliculas, Integer posicion) {

        FragmentViewPager fragmentViewPager = FragmentViewPager.dameUnFragment(new ContainerPeliculas(listaDePeliculas),posicion);
        pegarFragment(fragmentViewPager);
    }
}
