package com.example.recyclerstarwars.model;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String titulo;
    private String fechaEstreno;
    private String director;
    private String sinopsis;

    private String urlImagen;


    public Pelicula(String titulo, String fechaEstreno, String director, String sinopsis, String urlImagen) {
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.director = director;
        this.sinopsis = sinopsis;

        this.urlImagen = urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public String getDirector() {
        return director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getUrlImagen() { return urlImagen; }

}
