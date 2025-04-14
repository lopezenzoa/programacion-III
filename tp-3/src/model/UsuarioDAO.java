package model;

import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioDAO implements I_Repositorio<Usuario> {
    private Connection conexionMySQL;

    public UsuarioDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaUsuarios(); // Este metodo solo crea la tabla si no existe
    }

    public void crearTablaUsuarios() {
        String sql = "CREATE TABLE usuarios (\n" +
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
    public void insertar(Usuario usuario) throws SQLException {

    }

    @Override
    public List<Usuario> listar() throws SQLException {
        return List.of();
    }

    @Override
    public Usuario obtenerPorId(int id) throws SQLException {
        return null;
    }

    @Override
    public void actualizar(Usuario nuevo) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
