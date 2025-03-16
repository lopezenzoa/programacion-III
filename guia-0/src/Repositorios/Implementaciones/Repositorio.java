package Repositorios.Implementaciones;

import Modelo.Interfaces.Media;
import Repositorios.Iterfaces.Operable;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Repositorio implements Operable<Media> {
    private Map<Integer, Media> items;

    public Repositorio() {
        this.items = new TreeMap<>();
    }

    @Override
    public String agregar(Media media) {
        items.put(media.getId(), media);

        if (items.containsKey(media.getId()))
            return "\nAgregado/a!\n";

        return "Hubo un problema!\n";
    }

    @Override
    public String eliminar(int id) {
        items.remove(id);

        if (!items.containsKey(id))
            return "\nEliminado/a!\n";

        return "\nHubo un problema!\n";
    }

    @Override
    public TreeSet<Media> mostrar() {
        TreeSet<Media> values = new TreeSet<>();

        for (Map.Entry<Integer, Media> entry : items.entrySet())
            values.add(entry.getValue());

        return values;
    }

    @Override
    public TreeSet<Media> filtrar(String genero) {
        TreeSet<Media> filtro = new TreeSet<>();

        for (Media media : items.values()) {
            if (genero.compareTo(media.getGenero()) == 0)
                filtro.add(media);
        }

        return filtro;
    }

    @Override
    public String modificar(Media nuevo) {
        agregar(nuevo);

        return "\nModificado/a!\n";
    }
}
