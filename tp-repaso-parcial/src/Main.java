import controlador.ClienteControlador;
import controlador.PeluqueroControlador;
import controlador.TurnosControlador;
import enums.Estados;
import modelo.repositorio.ClienteDAO;
import modelo.repositorio.PeluqueroDAO;
import modelo.repositorio.TurnoDAO;

import java.time.LocalDateTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // RF01: CRUD de Clientes y Peluqueros
        ClienteDAO clienteDAO = new ClienteDAO();
        PeluqueroDAO peluqueroDAO = new PeluqueroDAO();
        TurnoDAO turnoDAO = new TurnoDAO();

        // inyeccion de dependencias de clienteDAO y peluqueroDAO
        ClienteControlador cCliente = new ClienteControlador(clienteDAO);
        PeluqueroControlador cPeluquero = new PeluqueroControlador(peluqueroDAO);
        TurnosControlador cTurno = new TurnosControlador(turnoDAO, cCliente, cPeluquero);

        // C - Create
        /*
        cCliente.insertar("Enzo", "2236", "enzo@gmail.com");
        cPeluquero.insertar("Emilio", "color");

         */

        // R - Read
        /*
        cCliente.listar().forEach(System.out::println);
        cPeluquero.listar().forEach(System.out::println);

         */

        // U - Update
        /*
        int clienteAModificar = cCliente.listar().getFirst().getId();

        cCliente.actualizar(
                clienteAModificar,
                cCliente.buscarPorId(clienteAModificar).getNombre(),
                "223600",
                cCliente.buscarPorId(clienteAModificar).getEmail()
        );

        System.out.println(cCliente.buscarPorId(clienteAModificar));

        int peluqueroAModificar = cPeluquero.listar().getFirst().getId();

        cPeluquero.actualizar(
                clienteAModificar,
                cCliente.buscarPorId(peluqueroAModificar).getNombre(),
                "corte"
        );

        System.out.println(cPeluquero.buscarPorId(peluqueroAModificar));

         */

        // D - Delete
        /*
        cCliente.eliminar(16);
        cCliente.eliminar(17);
        cCliente.eliminar(18);

        cPeluquero.eliminar(5);
        cPeluquero.eliminar(6);

         */

        // System.out.println("El cliente y el peluquero se han eliminado con exito.");

        // RF02: Registrar Turno
        // cTurno.registrarTurno(1, 1, LocalDateTime.now(), "color");
        // cTurno.registrarTurno(2, 2, LocalDateTime.of(2025, 5, 18, 13, 30), "color");

        // RF03: Listar Turnos por Peluquero
        // cTurno.buscarTurnosFuturosPorPeluqero(2).forEach(System.out::println);

        // RF04: Cambiar Estado de Turno
        /*
        cTurno.modificarEstado(4, Estados.CANCELADO);
        cTurno.modificarEstado(4, Estados.REALIZADO);
         */

        // RF05: Listar Turnos por Cliente
        



    }
}