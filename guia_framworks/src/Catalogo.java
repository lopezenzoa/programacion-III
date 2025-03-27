import java.util.TreeMap;

public class Catalogo {
    private TreeMap<String, Float> catalogo;

    public Catalogo(){
        this.catalogo= new TreeMap<>();
    }

    public TreeMap<String, Float> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(TreeMap<String, Float> catalogo) {
        this.catalogo = catalogo;
    }

    public String agregarProducto (String nombre, float precio){
        if (catalogo.put(nombre, precio) != null){
            return "El producto no se pudo ingreso al catalogo!";
        } else
            return "El producto se ingreso correctamente al catalogo!";
    }

    public String consultarPrecio( String nombre){
        if (catalogo.containsKey(nombre)) {
            return "El precio del producto: " + catalogo.get(nombre);
        }

        return "El producto no existe dentro del catalogo";
    }

    public String modificarPrecio( String nombre, float nuevoPrecio){
        if(catalogo.containsKey(nombre)){
            catalogo.remove(nombre);
            catalogo.put(nombre, nuevoPrecio);
            return "El precio fue modificado con exito!";
        }
        return "El producto no se encuentra en el catalogo!";
    }

    public String eliminarProducto(String nombre){
        if (catalogo.containsKey(nombre)) {
            catalogo.remove(nombre);
            return "El producto fue eliminado con exito!";
        }
        return "El producto no existe en el catalogo!";
    }
}
