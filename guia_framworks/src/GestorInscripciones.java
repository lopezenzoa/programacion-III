import java.util.HashSet;
import java.util.Set;

public class GestorInscripciones {
    private Set<String> inscripciones;

    public GestorInscripciones(){
        this.inscripciones= new HashSet<>();
    }

    public Set<String> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<String> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public String agregarNombre (String nombre){
        if(inscripciones.add(nombre)){
            return "Se agrego correctamente!";
        }else
            return "No se pudo agregar!";
    }

    public String verificarInscripto(String nombre) {
        if (inscripciones.contains(nombre))
            return "El usuario esta inscripto";

        return "El usuario no esta inscripto";
    }

    public String eliminarInscripto(String nombre) {
        if (inscripciones.contains(nombre)) {
            inscripciones.remove(nombre);
            return "Inscripto eliminado!";
        }

        return "Hubo un problema al remover";
    }
}
