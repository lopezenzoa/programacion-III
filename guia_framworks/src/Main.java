import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        /*
        AgendaContactos agendaContactos = new AgendaContactos();

        System.out.println(agendaContactos.agregarContacto("Enzo", "123"));
        System.out.println(agendaContactos.agregarContacto("Ailen", "456"));

        System.out.println(agendaContactos.buscarContacto("Enzo"));

        System.out.println(agendaContactos.modificarContacto("Ailen", "Lola", "124"));

        System.out.println(agendaContactos.eliminarContacto("Enzo"));

        for (Map.Entry<String, String> entry : agendaContactos.getAgenda().entrySet())
            System.out.println("\n" + entry.getKey() + " - " + entry.getValue());

         */

        // Ejercicio 2
        /*GestorTareas gestorTareas = new GestorTareas();

        System.out.println(gestorTareas.agregarTarea("Hacer Tarea 1"));
        System.out.println(gestorTareas.agregarTarea("Hacer Tarea 2"));

        System.out.println();

        System.out.println("Lista de tareas: ");
        for(String tarea : gestorTareas.getTareas()){
            System.out.println("\t" + tarea);
        }

        System.out.println();

        // System.out.println(gestorTareas.marcarTareaCompletada());
        // System.out.println(gestorTareas.marcarTareaCompletada());

        System.out.println("Lista de tareas: ");
        for(String tarea : gestorTareas.getTareas()){
            System.out.println("\t" + tarea);
        }

        System.out.println();

        System.out.println(gestorTareas.modificarDescripcion("Hacer Tarea 2", "Hacer Tarea 3"));

        System.out.println();

        System.out.println("Lista de tareas: ");
        for(String tarea : gestorTareas.getTareas()){
            System.out.println("\t" + tarea);
        }*/

        // Ejercicio 3

       /* GestorInscripciones inscripciones= new GestorInscripciones();

        System.out.println(inscripciones.agregarNombre("Ailen"));
        System.out.println(inscripciones.agregarNombre("Enzo"));

        System.out.println(inscripciones.verificarInscripto("Ailen"));

        System.out.println(inscripciones.eliminarInscripto("Ailen"));

        System.out.println();

        System.out.println("Lista de inscriptos:");
        for (String nombre : inscripciones.getInscripciones())
            System.out.println("\t" + nombre);*/


        // Ejercicio 4
        /*
        Catalogo catalogo = new Catalogo();

        System.out.println(catalogo.agregarProducto("auricular", 1200));
        System.out.println(catalogo.agregarProducto("laptop", 1500));
        System.out.println(catalogo.agregarProducto("smartphone", 1500));

        System.out.println(catalogo.consultarPrecio("laptop"));

        System.out.println();

        System.out.println(catalogo.modificarPrecio("auricular", 500));
        System.out.println(catalogo.eliminarProducto("laptop"));

        System.out.println();

        System.out.println("Lista de Productos");
        for (Map.Entry<String, Float> entry : catalogo.getCatalogo().entrySet())
            System.out.println("\t" + entry.getKey() + " $" + entry.getValue());


         */

        // Ejercicio 5
        Paciente paciente = new Paciente("Enzo", 1);
        Paciente paciente_2 = new Paciente("Ailen", 2);

        Guardia guardia = new Guardia();

        System.out.println(guardia.agregarPaciente(paciente));
        System.out.println(guardia.agregarPaciente(paciente_2));

        
    }
}