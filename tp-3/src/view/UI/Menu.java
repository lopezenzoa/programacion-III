package view.UI;

import model.Usuario;
import model.excepciones.NoAutorizadoException;

import java.util.Scanner;

public class Menu {
    private static Usuario usuarioActual; // Usuario autenticado

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simular login
        // usuarioActual = Autenticador.iniciarSesion(scanner); // Devuelve un Usuario autenticado

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    /*
                    case 1 -> ConexionSQLite.conectar();
                    case 2 -> Actividades.crearNuevoUsuario(scanner);
                    case 3 -> Autenticador.iniciarSesion(scanner);
                    case 4 -> validarPermiso("GESTOR", "ADMINISTRADOR", () -> Actividades.listarUsuarios());
                    case 5 -> validarPermiso("GESTOR", "ADMINISTRADOR", () -> Actividades.buscarUsuario(scanner));
                    case 6 -> Actividades.modificarDatosUsuario(scanner, usuarioActual);
                    case 7 -> validarPermiso("GESTOR", "ADMINISTRADOR", () -> Actividades.eliminarUsuario(scanner));
                    case 8 -> Actividades.listarCuentas(scanner, usuarioActual);
                    case 9 -> Actividades.obtenerSaldoTotal(scanner, usuarioActual);
                    case 10 -> Actividades.realizarDeposito(scanner, usuarioActual);
                    case 11 -> Actividades.realizarTransferencia(scanner, usuarioActual);
                    case 12 -> validarPermiso("GESTOR", "ADMINISTRADOR", () -> Actividades.contarUsuariosPorPermiso());
                    case 13 -> validarPermiso("GESTOR", "ADMINISTRADOR", () -> Actividades.contarCuentasPorTipo());
                    case 14 -> validarPermiso("ADMINISTRADOR", () -> Actividades.usuarioConMayorSaldo());
                    case 15 -> validarPermiso("ADMINISTRADOR", () -> Actividades.usuariosOrdenadosPorSaldo());
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida.");

                     */
                }
            } catch (Exception e) {
                // Cambiar Exception por NoAutorizadoException
                System.out.println("⛔ " + e.getMessage());
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
        \n--- MENÚ PRINCIPAL ---
        1. Conectar a la base de datos
        2. Crear nuevo usuario
        3. Iniciar sesión
        4. Listar todos los usuarios
        5. Buscar usuario por DNI o Email
        6. Modificar datos de usuario
        7. Eliminar usuario
        8. Listar cuentas de usuario
        9. Obtener saldo total de usuario
        10. Realizar depósito
        11. Realizar transferencia
        12. Cantidad de usuarios por permiso
        13. Cantidad total de cuentas por tipo
        14. Usuario con mayor saldo total
        15. Usuarios ordenados por saldo
        0. Salir
        """);
    }
}
