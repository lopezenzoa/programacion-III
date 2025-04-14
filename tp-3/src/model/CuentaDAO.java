package model;

import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CuentaDAO implements I_Repositorio<Cuenta> {
    private Connection conexionMySQL;

    public CuentaDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaCuentas();
    }

    public void crearTablaCuentas() {
        String sql = "CREATE TABLE cuentas (\n" +
                "  id_cuenta INT AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                "  id_usuario INT,\n" +
                "  tipo VARCHAR(255),\n" +
                "  saldo DOUBLE,\n" +
                "  fecha_creacion VARCHAR(255),\n" +
                "  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE\n" +
                ");";

        try (Statement stmt =  conexionMySQL.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Cuenta cuenta) throws SQLException {

    }

    @Override
    public List<Cuenta> listar() throws SQLException {
        return List.of();
    }

    @Override
    public Cuenta obtenerPorId(int id) throws SQLException {
        return null;
    }

    @Override
    public void actualizar(Cuenta nuevo) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
