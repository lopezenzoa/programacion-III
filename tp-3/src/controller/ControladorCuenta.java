package controller;

import controller.enums.TipoCuenta;
import model.Cuenta;
import model.CuentaDAO;
import model.Usuario;
import view.VistaCuenta;
import view.VistaUsuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ControladorCuenta {
    private CuentaDAO modelo;

    public ControladorCuenta() throws SQLException {
        this.modelo = new CuentaDAO();
    }

    public void agregarCuenta(int id_usuario, TipoCuenta tipo, float saldo) throws SQLException {
        modelo.insertar(new Cuenta(id_usuario, tipo, saldo));
    }

    public List<Cuenta> listarCuentas(int id_usuario) throws SQLException {
        return modelo.listar()
                .stream()
                .filter(cuenta -> cuenta.getId_usuario() == id_usuario)
                .toList();
    }

    public Optional<Cuenta> obtenerCuentaPorId(int id_cuenta) throws SQLException {
        return Optional.of(modelo.obtenerPorId(id_cuenta));
    }

    public void mostrarCuenta(int id) throws SQLException {
        Optional<Cuenta> cuenta = obtenerCuentaPorId(id);

        cuenta.ifPresent(value -> VistaCuenta.mostrarCuenta(
                value.getId_cuenta(),
                value.getId_usuario(),
                value.getTipo(),
                value.getSaldo()
        ));
    }

    public float saldoTotalPorCuenta(int id_usuario) throws SQLException {
        List<Cuenta> cuentas = listarCuentas(id_usuario);

        return cuentas.stream()
                .map(Cuenta::getSaldo)
                .reduce(0.0F, Float::sum);
    }

    public boolean depositar(int id_cuenta, float cantidad) throws SQLException {
        Cuenta cuenta = modelo.obtenerPorId(id_cuenta);

        if (cantidad <= 0)
            return false;

        cuenta.setSaldo(cuenta.getSaldo() + cantidad);
        modelo.actualizar(cuenta);

        return true;
    }

    public boolean transferir(int id_cuenta_origen, int id_cuenta_destino, float cantidad) throws SQLException {
        Cuenta cuentaOrigen = modelo.obtenerPorId(id_cuenta_origen);
        Cuenta cuentaDestino = modelo.obtenerPorId(id_cuenta_destino);

        if (cantidad <= 0 || cuentaOrigen.getSaldo() >= cantidad)
            return false;

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);

        modelo.actualizar(cuentaOrigen);
        modelo.actualizar(cuentaDestino);

        return true;
    }
}
