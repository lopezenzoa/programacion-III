import controller.ControladorCredenciales;
import controller.ControladorCuenta;
import controller.ControladorUsuario;
import controller.enums.Permisos;
import controller.enums.TipoCuenta;
import model.Credencial;
import model.Cuenta;
import model.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        ControladorCuenta controladorCuenta = new ControladorCuenta();
        ControladorCredenciales controladorCredenciales = new ControladorCredenciales();

        // Ejercicio 2
        /*
        Usuario u1 = new Usuario("Enzo", "Lopez", "44783626", "enzo@gmail.com"); // simula los datos de un nuevo usuario
        Credencial credencial = new Credencial();
        Cuenta cuenta = new Cuenta();

        int id_usuario = controladorUsuario.agregarUsuario(
                u1.getNombre(),
                u1.getApellido(),
                u1.getDni(),
                u1.getEmail()
        );

        credencial.setId_usuario(id_usuario);
        credencial.setUsername("enzo"); // se deberia pedir por pantalla el nombre
        credencial.setPassword("1234");
        credencial.setPermiso(Permisos.CLIENTE);

        // Agrega la crendencial a la DB
        controladorCredenciales.agregarCredencial(
                credencial.getId_usuario(),
                credencial.getUsername(),
                credencial.getPassword(),
                credencial.getPermiso()
        );

        // Automaticamente, al usuario se le agrega una cuenta nueva de tipo 'CAJA_AHORRO'
        cuenta.setId_usuario(id_usuario);
        cuenta.setSaldo(0);
        cuenta.setTipo(TipoCuenta.CAJA_AHORRO);

        // Agrega la cuenta a la DB
        controladorCuenta.agregarCuenta(
                cuenta.getId_usuario(),
                cuenta.getTipo(),
                cuenta.getSaldo()
        );

        System.out.println("El usuario se registro con exito al sistema");

        // Para implementar: restriccion sobre la cantidad de cuentas que tiene el usuario

         */

        // Ejercicio 3
        /*
        String username = "enzo";
        String password = "1234$";

        Credencial credencial = controladorCredenciales.validarCredenciales(username, password);

        if (credencial != null)
            System.out.println("Ingresaste al sistema correctamente");
        else
            System.out.println("El usuario y/o contraseña son incorrectos");

         */

        // Ejercicio 4
        /*
        List<Usuario> usuariosRegistrados = controladorUsuario.listarTodos();

        usuariosRegistrados.forEach(System.out::println); // la info deberia mostrarse adentro del metodo 'listarTodos' usando VistaUsuario

         */

        // Ejercicio 5
        /*
        String dni = "44783626$";
        String email = "enzo@gmail.com";

        Optional<Usuario> usuarioOptional = controladorUsuario.buscarPorDNIMail(dni, email);

        usuarioOptional.ifPresent(System.out::println);

         */

        // Ejercicio 6
        /*
        String dni = "44783626$";

        Optional<Usuario> usuarioOptional = controladorUsuario.buscarPorDNIMail(dni, ""); // el mail se lo paso vacío porque busco por DNI

        if (usuarioOptional.isPresent()) {
            // Modifica los datos del usuario
            Usuario usuario = usuarioOptional.get();

            usuario.setEmail("enzo2@gmail.com");
            usuario.setApellido("Lopez Alba");

            // Guarda los cambios del usuario en la DB
            controladorUsuario.modificarUsuario(
                    usuario.getId_usuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getDni(),
                    usuario.getEmail()
            );

            System.out.println("El usuario fue modificado");
        } else {
            System.out.println("El usuario con DNI " + dni + " no existe");
        }

         */

        // Ejercicio 7
        /*
        Usuario usuario = new Usuario("Mateo", "Lopez", "12345678", "mateo@gmail.com");

        int id_usuario = controladorUsuario.agregarUsuario(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getDni(),
                usuario.getEmail()
        ); // el programa deberia permitir que el GESTOR/ADMIN pudiera elegir el ID del usuario a eliminar

        controladorUsuario.eliminarUsuario(id_usuario);
        System.out.println("El usuario con ID " + id_usuario + " fue eliminado");

         */

        // Ejercicio 8
        /*
        String dni = "44783626$";
        String email = "enzo@gmail.com";

        Optional<Usuario> optionalUsuario = controladorUsuario.buscarPorDNIMail(dni, email);

        if (optionalUsuario.isPresent()) {
            List<Cuenta> cuentas = controladorCuenta.listarCuentas(optionalUsuario.get().getId_usuario());

            cuentas.forEach(System.out::println);
        } else {
            System.out.println("El usuario con DNI " + dni + " no existe");
        }

         */

        // Ejercicio 9
        /*
        String dni = "12345678"; // usuario con ID 1
        String email = "enzo@gmail.com";

        Optional<Usuario> optionalUsuario = controladorUsuario.buscarPorDNIMail(dni, email);

        if (optionalUsuario.isPresent()) {
            float saldoTotal = controladorCuenta.saldoTotalPorCuenta(optionalUsuario.get().getId_usuario());

            System.out.println("Saldo total: " + saldoTotal);
        } else {
            System.out.println("El usuario con DNI " + dni + " no existe");
        }

         */

        // Ejercicio 10
        /*
        String dni = "44783626";
        String email = "enzo@gmail.com";

        Optional<Usuario> optionalUsuario = controladorUsuario.buscarPorDNIMail(dni, email);

        if (optionalUsuario.isPresent()) {
            List<Cuenta> cuentas = controladorCuenta.obtenerCuentasPorUsuario(optionalUsuario.get().getId_usuario()); // muestra las cuentas del usuario

            Optional<Cuenta> cuentaOptional = cuentas.stream().findAny(); // en este caso, el usuario tiene una sola cuenta

            if (cuentaOptional.isPresent()) {
                int id_cuenta = cuentaOptional.get().getId_cuenta();
                float cantidad = 4500; // deberia ser un dato ingresado por el usuario

                controladorCuenta.depositar(id_cuenta, cantidad);

                System.out.println("Se depositaron $" + cantidad + " a la cuenta con ID " + id_cuenta);
            } else {
                System.out.println("la cuenta con ID " + dni + " no existe");
            }
        } else {
            System.out.println("El usuario con DNI " + dni + " no existe");
        }

         */

        // Ejercicio 11
        /*
        String dni = "44783626";
        String email = "enzo@gmail.com";

        Optional<Usuario> optionalUsuario = controladorUsuario.buscarPorDNIMail(dni, email);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            // Agrega una nueva cuenta
            int id_cuenta_destino = controladorCuenta.agregarCuenta(usuario.getId_usuario(), TipoCuenta.CUENTA_CORRIENTE, 0);

            List<Cuenta> cuentas = controladorCuenta.obtenerCuentasPorUsuario(optionalUsuario.get().getId_usuario()); // muestra las cuentas del usuario

            Optional<Cuenta> cuentaOptional = cuentas.stream()
                    .filter(c -> c.getTipo().equals(TipoCuenta.CAJA_AHORRO))
                    .findFirst(); // en este caso, el usuario tiene una sola cuenta entonces tiene sentido hacer .equals sobre el tipo

            if (cuentaOptional.isPresent()) {
                int id_cuenta_origen = cuentaOptional.get().getId_cuenta();
                float cantidad = 4500; // deberia ser un dato ingresado por el usuario

                boolean operacionExitosa = controladorCuenta.transferir(id_cuenta_origen, id_cuenta_destino, cantidad);

                System.out.println(operacionExitosa);

                System.out.println("Se tran" + "transfirieron $" + cantidad + " de la cuenta con ID " + id_cuenta_origen + " a la cuenta con ID " + id_cuenta_destino);
            } else {
                System.out.println("la cuenta con ID " + dni + " no existe");
            }
        } else {
            System.out.println("El usuario con DNI " + dni + " no existe");
        }

         */

        // Ejercicio 12
        // controladorCredenciales.agruparPorTipo().forEach((permiso, cantidad) -> System.out.println(permiso + ": " + cantidad));

        // Ejercicio 13
        // controladorCuenta.agruparPorTipo().forEach((tipo, cantidad) -> System.out.println(tipo + ": " + cantidad));

        // Ejercicio 14
        /*
        int idUsuarioConMayorSaldo = controladorCuenta.obtenerIdUsuarioConMayorSaldo();
        controladorUsuario.mostrarUsuario(idUsuarioConMayorSaldo);

         */

        // Ejercicio 15
        /*
        List<Integer> idUsuarios = controladorCuenta.ordenarIdDeUsuariosPorSaldo();

        // No lo puedo llamar con programacion funcional porque el metodo mostrarusuario tiene que manejar la excepcion SQLException
        for (Integer idUsuario : idUsuarios)
            controladorUsuario.mostrarUsuario(idUsuario);

         */
    }
}