import java.util.HashMap;
import java.util.HashSet;

public class AgendaContactos {
    HashMap<String, String> agenda;

    public AgendaContactos() {
        this.agenda = new HashMap<>();
    }

    public HashMap<String, String> getAgenda() {
        return agenda;
    }

    public void setAgenda(HashMap<String, String> agenda) {
        this.agenda = agenda;
    }

    public String agregarContacto(String nombre, String telefono) {
        if (agenda.put(nombre, telefono) != null)
            return "Hubo un problema al agregar el contacto";

        return "Contacto agregado";
    }

    public String buscarContacto(String nombre){
        if (agenda.containsKey(nombre))
            return agenda.get(nombre);

        return null;
    }

    public String modificarContacto(String nombre, String nuevoNombre, String nuevoTelefono){
        if(buscarContacto(nombre) != null){
            agenda.remove(nombre);
            agenda.put(nuevoNombre, nuevoTelefono);
            return "Contacto modificado con exito!";
        }
        return "El contacto no se encuentra en la agenda! ";
    }

    public String eliminarContacto(String nombre) {
        if (buscarContacto(nombre) != null) {
            agenda.remove(nombre);
            return "Contacto Eliminado";
        }

        return "Hubo un problema en la eliminacion del contacto";
    }
}