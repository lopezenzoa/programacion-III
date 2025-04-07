import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        DireccionDAO direccionDAO = new DireccionDAO();

        // Ejercicio 2
        /*
        Alumno alumno = new Alumno(1, "Enzo", "Lopez", 22, "enzo@gmail.com");
        Alumno alumno_1 = new Alumno(1, "Ailen", "Martinez", 27, "ailen@gmail.com");

        // Insercion de alumnos
        System.out.println(alumnoDAO.insertarAlumno(alumno));
        System.out.println(alumnoDAO.insertarAlumno(alumno_1));


         */

        // Ejercicio 3
        /*
        Direccion direccion = new Direccion(1, "3 de Febrero", 5074, 8);
        Direccion direccion_1 = new Direccion(2, "Las hayas", 404, 9);

        System.out.println(direccionDAO.insertarDireccion(direccion));
        System.out.println(direccionDAO.insertarDireccion(direccion_1));

         */

        // Ejercicio 4
        /*
        System.out.println("Lista de Alumnos traidos desde la BD");
        alumnoDAO.listarAlumnos().forEach(System.out::println);


        // Tarea para casa: pensar como hacer para el caso de que un alumno tenga mas de una direccion (pista: usar la lista con valores de tipo List<Direccion>)
        /*
        Map<Alumno, Direccion> alumnosDirecciones = alumnoDAO.listarAlumnosConDirecciones();

        for (Map.Entry<Alumno, Direccion> entry : alumnosDirecciones.entrySet()) {
            System.out.println(entry.getKey() + " - Direccion: " + entry.getValue().getCalle() + " " + entry.getValue().getAltura());
        }

         */

        // Ejercicio 5
        /*
        System.out.println(direccionDAO.verDireccion(9));

         */

        // Ejercicio 6
        /*
        System.out.println("Datos Actualizados del Alumno");
        System.out.println(alumnoDAO.actualizarAlumno(8, 23));

         */

        // Ejercicio 7
        /*
        System.out.println(alumnoDAO.eliminarAlumno(9));
        */

        // Ejercicio 8
        System.out.println(direccionDAO.eliminarDireccion(6));
    }
}