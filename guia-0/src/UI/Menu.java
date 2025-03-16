package UI;

import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Juego;
import Modelo.Interfaces.Media;
import Repositorios.Implementaciones.Repositorio;
import java.util.Scanner;

public class Menu {
    // Gracias al enfoque orientado a Interfaces, solamente es encesario un repositorio donde se almacenan todos los objetos que se instancien y cumplan con la interfaz Media
    private static Repositorio repositorio = new Repositorio();

    /*
    public static void mostrarOperaciones() {
        System.out.println("MENU DE OPERACIONES\n" +
                "\t1. Agregar Nuevo Juego\n" +
                "\t2. Agregar Nueva Expansion\n" +
                "\t3. Eliminar Juego\n" +
                "\t4. Eliminar Expansion\n" +
                "\t5. Listar Repositorio\n" +
                "\n\t0. Salir");

        System.out.println();
    }

    public static int elegirOperacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de la operacion que quiere realizar:");
        int operacion = scanner.nextInt();
        scanner.nextLine();

        return operacion;
    }

    public static void ejecutarOperacion(int operacion) {
        // Por simplicidad todas las clases son instanciadas con informacion ficticia

        if (operacion == 1) {
            Juego juego = new Juego("Zelda", "Nintendo", "Aventura", 123, 1);
            System.out.println(repositorio.agregar(juego));
        } else if (operacion == 2) {
            Expansion expansion = new Expansion("DLC Zelda", "Nintendo", "Aventura", 1234, "2024-03-15");
            System.out.println(repositorio.agregar(expansion));
        } else if (operacion == 5) {
            for (Media media : repositorio.mostrar())
                System.out.println("\t" + media.toString() + "\n");
        }
    }

     */

    public static void ejecutar() {
        // Agregar Nuevo Juego
        Juego juego = new Juego("Zelda", "Nintendo", "Aventura", 123, 1);
        System.out.println(repositorio.agregar(juego));

        // Agregar Nueva Expansion
        Expansion expansion = new Expansion("DLC Zelda", "Nintendo", "Aventura", 1234, "2024-03-15");
        System.out.println(repositorio.agregar(expansion));


        // Eliminar Objeto por Identificador
        // System.out.println(repositorio.eliminar(expansion.getId()));

        // Mostrar todos los objetos de la coleccion de forma ordenada por titulo
        for (Media media : repositorio.mostrar())
            System.out.println(media);

        System.out.println();

        // Filtrar objetos por género
        for (Media media : repositorio.filtrar(expansion.getGenero()))
            System.out.println(media);


        // Modificar un único atributo de un objeto sin afectar el resto de sus datos
        Expansion expansion_2 = new Expansion("DLC Zelda 2", "Nintendo", "Aventura", 1234, "2024-03-15");
        System.out.println(repositorio.modificar(expansion_2));

        /*
        mostrarOperaciones();

        int operacion = 0;

        do {
            operacion = elegirOperacion();
            ejecutarOperacion(operacion);
        } while (operacion == 0);

         */
    }
}
