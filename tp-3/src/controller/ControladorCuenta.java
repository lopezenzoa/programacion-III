package controller;

import controller.enums.TipoCuenta;
import model.Cuenta;
import model.CuentaDAO;
import model.Usuario;
import view.VistaCuenta;
import view.VistaUsuario;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

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

    public Map<String, Long> agruparPorTipo() throws SQLException {
        return modelo.listar()
                .stream()
                .collect(Collectors.groupingBy(
                        credencial -> credencial.getTipo().toString(),
                        Collectors.counting()));
    }

    // Lo que debería hacer este metodo para que sea completo, es sumar los saldos de todas las cuentas de un mismo usuario y obtener asi el mayor saldo por usuario
    public int obtenerIdUsuarioConMayorSaldo() throws SQLException {
        List<Cuenta> cuentas = modelo.listar();

        double saldoMayor = cuentas.stream()
                .mapToDouble(Cuenta::getSaldo)
                .max().getAsDouble();


        Cuenta cuentaMayorSaldo = cuentas.stream()
                .filter(cuenta -> cuenta.getSaldo() == saldoMayor)
                .limit(1) // Si hubiera mas de una cuenta con el mismo saldo mayor, solo tomo la primera
                .toList()
                .getFirst();

        return cuentaMayorSaldo.getId_usuario();
    }

    // La razon por la que retorno los IDs de los usuarios es porque no quiero que romper el SRP de solid
    public List<Integer> ordenarIdDeUsuariosPorSaldo() throws SQLException {
        List<Cuenta> cuentas = modelo.listar();

        List<Cuenta> cuentasOrdenadas = cuentas.stream()
                .sorted(Comparator.comparing(Cuenta::getSaldo).reversed()) // .reversed() despues del comparador para ordenar de mayor a menor
                .toList();

        return cuentasOrdenadas.stream().map(Cuenta::getId_usuario).toList();
    }
}
