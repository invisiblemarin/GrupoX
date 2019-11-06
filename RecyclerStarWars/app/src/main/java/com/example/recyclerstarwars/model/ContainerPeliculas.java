package com.example.recyclerstarwars.model;

import java.io.Serializable;
import java.util.List;

public class ContainerPeliculas implements Serializable {

    private List<Pelicula> listaDePeliculas;

    public ContainerPeliculas(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }

    public List<Pelicula> getListaDePeliculas() {
        return listaDePeliculas;
    }

    public void setListaDePeliculas(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }
}
