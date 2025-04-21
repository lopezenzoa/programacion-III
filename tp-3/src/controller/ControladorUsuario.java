package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.VistaUsuario;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class ControladorUsuario {
    private UsuarioDAO modelo;

    public ControladorUsuario() throws SQLException {
        this.modelo = new UsuarioDAO();
    }

    public int agregarUsuario(String nombre, String apellido, String dni, String email) throws SQLException {
        return modelo.insertar(new Usuario(nombre, apellido, dni, email));
    }

    public Optional<Usuario> obtenerUsuarioPorID(int id_usuario) throws SQLException {
        return Optional.of(modelo.obtenerPorId(id_usuario));
    }

    public void mostrarUsuario(int id) throws SQLException {
        Optional<Usuario> usuario = obtenerUsuarioPorID(id);

        usuario.ifPresent(value -> VistaUsuario.mostrarUsuario(
                value.getId_usuario(),
                value.getNombre(),
                value.getApellido(),
                value.getDni(),
                value.getEmail()
        ));
    }

    public List<Usuario> listarTodos() throws SQLException {
        return modelo.listar();
    }

    public Optional<Usuario> buscarPorDNI(String dni) throws SQLException {
        List<Usuario> usuarios = modelo.listar();

        return usuarios.stream()
                .filter(u -> u.getDni().equals(dni))
                .findAny();
    }

    public Optional<Usuario> buscarPorEmail(String email) throws SQLException {
        List<Usuario> usuarios = modelo.listar();

        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .findAny();
    }

    public void modificarUsuario(int id_usuario, String nombre, String apellido, String dni, String email) throws SQLException {
        modelo.actualizar(new Usuario(id_usuario, nombre, apellido, dni, email));
    }

    public void eliminarUsuario(int id_usuario) throws SQLException {
        modelo.eliminar(id_usuario);
    }
}
