package Repositorios.Iterfaces;

import java.util.TreeMap;
import java.util.TreeSet;

public interface Operable<M> {
    String agregar(M media);
    String eliminar(int id);
    TreeSet<M> mostrar();
    TreeSet<M> filtrar(String genero);
    String modificar(M media);
}
