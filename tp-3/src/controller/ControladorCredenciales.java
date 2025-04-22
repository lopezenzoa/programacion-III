package controller;

import controller.enums.Permisos;
import model.Credencial;
import model.CredencialDAO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControladorCredenciales {
    private CredencialDAO modelo;

    public ControladorCredenciales() throws SQLException {
        this.modelo = new CredencialDAO();
    }

    public void agregarCredencial(int id_usuario, String username, String password, Permisos permisos) throws SQLException {
        modelo.insertar(new Credencial(id_usuario, username, password, permisos));
    }

    /*
    public Credencial validarCredenciales(String username, String password) throws SQLException {
        Optional<Credencial> credencial = modelo.obtenerPorUsername(username);

        // retorno el ID del usuario para depues buscarlo en la tabla por el controlador correspondiente
        return credencial.orElse(null);

    }

     */

    public Map<String, Long> agruparPorTipo() throws SQLException {
        return modelo.listar()
                .stream()
                .collect(Collectors.groupingBy(
                        credencial -> credencial.getPermiso().toString(),
                        Collectors.counting()));
    }


}
