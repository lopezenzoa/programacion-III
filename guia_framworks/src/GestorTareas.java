import java.util.ArrayDeque;
import java.util.Queue;

public class GestorTareas {
    Queue<String> tareas;

    public GestorTareas() {
        this.tareas = new ArrayDeque<>();
    }

    public Queue<String> getTareas() {
        return tareas;
    }

    public void setTareas(Queue<String> tareas) {
        this.tareas = tareas;
    }

    public String agregarTarea(String descripcion) {
        if (tareas.add(descripcion))
            return "Tarea Agregada\n\t" + descripcion;

        return "Hubo un problema en la inserción de la tarea";
    }

    public String marcarTareaCompletada() {
        String ultimaTarea = tareas.peek();

        if (tareas.poll() != null)
            return "Tarea Marcada como Completada!" + "\n\t" + ultimaTarea;

        return "Hubo un problema al marcar la tarea";
    }

    public String modificarDescripcion(String descripcion, String nuevaDescripcion) {
        Queue<String> tareasAuxiliar = new ArrayDeque<>();

        boolean encontrada = false;

        while (!encontrada || tareas.isEmpty()) {
            String tarea = tareas.peek();

            if (tarea.equals(descripcion)) {
                tareas.remove();
                tareas.add(nuevaDescripcion);

                encontrada = true;
            } else
                tareasAuxiliar.add(tareas.remove());
        }

        if (encontrada) {
            while (!tareasAuxiliar.isEmpty()) {
                tareas.add(tareasAuxiliar.remove());
            }

            return "Tarea modificada!";
        }

        return "La tarea no se encuentra";
    }
}
