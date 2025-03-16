package Modelo.Implementaciones;

import Modelo.Interfaces.Media;

public class Expansion implements Media {
    private String titulo;
    private String creador;
    private String genero;
    private int id;
    private String lanzamiento;

    public Expansion(String titulo, String creador, String genero, int id, String lanzamiento) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = id;
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getCreador() {
        return creador;
    }

    @Override
    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String toString() {
        return "Expansion{" +
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                ", lanzamiento='" + lanzamiento + '\'' +
                '}';
    }

    @Override
    public int compareTo(Media m) {
        return Integer.compare(id, m.getId());
    }
}
