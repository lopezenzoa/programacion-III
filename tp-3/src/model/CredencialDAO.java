package model;

import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CredencialDAO implements I_Repositorio<Credencial> {
    private Connection conexionMySQL;

    public CredencialDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaCredenciales();
    }

    public void crearTablaCredenciales() {
        String sql = "CREATE TABLE credenciales (\n" +
                "  id_credencial INT AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                "  id_usuario INT,\n" +
                "  username VARCHAR(255),\n" +
                "  pass VARCHAR(255),\n" +
                "  permiso VARCHAR(255),\n" +
                "  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE\n" +
                ");\n";

        try (Statement stmt = conexionMySQL.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertar(Credencial credencial) throws SQLException {

    }

    @Override
    public List<Credencial> listar() throws SQLException {
        return List.of();
    }

    @Override
    public Credencial obtenerPorId(int id) throws SQLException {
        return null;
    }

    @Override
    public void actualizar(Credencial nuevo) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
