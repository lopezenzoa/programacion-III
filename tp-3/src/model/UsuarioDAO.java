package model;

import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO implements I_Repositorio<Usuario> {
    private Connection conexionMySQL;

    public UsuarioDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaUsuarios(); // Este metodo solo crea la tabla si no existe
    }

    public void crearTablaUsuarios() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n" +
                "  id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                "  nombre VARCHAR(255),\n" +
                "  apellido VARCHAR(255),\n" +
                "  dni VARCHAR(255),\n" +
                "  email VARCHAR(255),\n" +
                "  fecha_creacion VARCHAR(255)\n" +
                ");\n";

        try (Statement stmt = conexionMySQL.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nombre, apellido, dni, email) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getDni());
            pstmt.setString(4, usuario.getEmail());

            pstmt.executeUpdate();

            // Retorna el ultimo ID ingresado a la tabla (solo funciona inmediatamente despues de un INSERT)
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() AS id_usuario;");
            if (rs.next())
                return rs.getInt("id_usuario");

            return -1;
        }
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";

        try (Statement stmt = conexionMySQL.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = getUsuario(rs);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    @Override
    public Usuario obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = " + id + ";";

        try (Statement stmt = conexionMySQL.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next())
                return getUsuario(rs);
        }

        return null;
    }

    @Override
    public void actualizar(Usuario nuevo) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, dni = ?, email = ? WHERE id_usuario = ?;";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setString(1, nuevo.getNombre());
            pstmt.setString(2, nuevo.getApellido());
            pstmt.setString(3, nuevo.getDni());
            pstmt.setString(4, nuevo.getEmail());
            pstmt.setInt(5, nuevo.getId_usuario());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id_usuario = " + id + ";";

        try (Statement stmt = conexionMySQL.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    private static Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId_usuario(rs.getInt("id_usuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setDni(rs.getString("dni"));
        usuario.setEmail(rs.getString("email"));

        return usuario;
    }
}
