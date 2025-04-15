package controller;

import controller.enums.Permisos;
import model.Credencial;
import model.CredencialDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ControladorCredenciales {
    private CredencialDAO modelo;

    public ControladorCredenciales() throws SQLException {
        this.modelo = new CredencialDAO();
    }

    public void agregarCredencial(int id_usuario, String username, String password, Permisos permisos) throws SQLException {
        modelo.insertar(new Credencial(id_usuario, username, password, permisos));
    }

    public Credencial validarCredenciales(String username, String password) throws SQLException {
        Optional<Credencial> credencial = modelo.obtenerPorUsername(username);

        // retorno el ID del usuario para depues buscarlo en la tabla por el controlador correspondiente
        return credencial.orElse(null);

    }
}
