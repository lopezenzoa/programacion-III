package Modelo.Interfaces;

public interface Media extends Comparable<Media> {
    String getTitulo();
    void setTitulo(String titulo);
    String getCreador();
    void setCreador(String creador);
    String getGenero();
    void setGenero(String genero);
    int getId();
    String toString();
    int compareTo(Media m);
}
