import controller.ControladorCredenciales;
import controller.ControladorCuenta;
import controller.ControladorUsuario;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        try {
            ControladorCredenciales controladorCredenciales = new ControladorCredenciales();

            controladorCredenciales.agruparPorTipo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */

        try {
            ControladorCuenta controladorCuenta = new ControladorCuenta();
            ControladorUsuario controladorUsuario = new ControladorUsuario();

            // System.out.println(controladorCuenta.agruparPorTipo());

            // int idUsuarioConMayorSaldo = controladorCuenta.obtenerIdUsuarioConMayorSaldo();

            // controladorUsuario.mostrarUsuario(idUsuarioConMayorSaldo);

            List<Integer> idUsuarios = controladorCuenta.ordenarIdDeUsuariosPorSaldo();

            // No lo puedo llamar con programacion funcional porque el metodo mostrarusuario tiene que manejar la excepcion
            for (Integer idUsuario : idUsuarios)
                controladorUsuario.mostrarUsuario(idUsuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}