package com.example.recyclerstarwars.controller;

import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.model.PeliculaDao;

import java.util.List;

public class PeliculaController {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista
    public List<Pelicula> traerPeliculas(){
        PeliculaDao peliculaDao = new PeliculaDao();
        return peliculaDao.traerPeliculas();
    }
}
