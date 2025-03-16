package Modelo.Implementaciones;

import Modelo.Interfaces.Media;

public class Juego implements Media {
    private String titulo;
    private String creador;
    private String genero;
    private int id;
    private int version;

    public Juego(String titulo, String creador, String genero, int id, int version) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = id;
        this.version = version;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                ", version=" + version +
                '}';
    }

    @Override
    public int compareTo(Media m) {
        return Integer.compare(id, m.getId());
    }
}
