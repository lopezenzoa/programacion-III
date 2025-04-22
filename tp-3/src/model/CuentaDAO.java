package model;

import controller.enums.TipoCuenta;
import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO implements I_Repositorio<Cuenta> {
    private Connection conexionMySQL;

    public CuentaDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaCuentas();
    }

    public void crearTablaCuentas() {
        String sql = "CREATE TABLE IF NOT EXISTS cuentas (\n" +
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
    public int insertar(Cuenta cuenta) throws SQLException {
        String sql = "INSERT INTO cuentas(id_usuario, tipo, saldo, fecha_creacion) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setInt(1, cuenta.getId_usuario());
            pstmt.setString(2, cuenta.getTipo().toString());
            pstmt.setFloat(3, cuenta.getSaldo());
            pstmt.setString(4, "NOW()");

            pstmt.executeUpdate();

            // Retorna el ultimo ID ingresado a la tabla (solo funciona inmediatamente despues de un INSERT)
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() AS id_cuenta;");
            if (rs.next())
                return rs.getInt("id_cuenta");

            return -1;
        }
    }

    @Override
    public List<Cuenta> listar() throws SQLException {
        String sql = "SELECT * FROM cuentas;";
        List<Cuenta> cuentas = new ArrayList<>();

        try (Statement statement = conexionMySQL.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
                cuentas.add(crearCuenta(rs));
        }

        return cuentas;
    }

    @Override
    public Cuenta obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM cuentas WHERE id_cuenta = " + id + ";";

        try (Statement stm = conexionMySQL.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next())
                return crearCuenta(rs);
        }

        return null;
    }

    @Override
    public void actualizar(Cuenta nuevo) throws SQLException {
        String sql = "UPDATE cuentas SET id_usuario = ?, tipo = ?, saldo = ? WHERE id_cuenta = ?;";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setInt(1, nuevo.getId_usuario());
            pstmt.setString(2, nuevo.getTipo().toString());
            pstmt.setFloat(3, nuevo.getSaldo());
            pstmt.setInt(4, nuevo.getId_cuenta());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM cuentas WHERE id_cuenta = " + id + ";";

        try (Statement stmt = conexionMySQL.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    private static Cuenta crearCuenta(ResultSet rs) throws SQLException {
        Cuenta cuenta = new Cuenta();
        cuenta.setId_cuenta(rs.getInt("id_cuenta"));
        cuenta.setId_usuario(rs.getInt("id_usuario"));
        cuenta.setTipo(TipoCuenta.valueOf(rs.getString("tipo")));
        cuenta.setSaldo(rs.getFloat("saldo"));

        return cuenta;
    }
}
