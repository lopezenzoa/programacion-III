package model;

import controller.enums.Permisos;
import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredencialDAO implements I_Repositorio<Credencial> {
    private Connection conexionMySQL;

    public CredencialDAO() throws SQLException {
        this.conexionMySQL = ConexionMySQL.getInstance().getConnection();
        crearTablaCredenciales();
    }

    public void crearTablaCredenciales() {
        String sql = "CREATE TABLE IF NOT EXISTS credenciales (\n" +
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
    public int insertar(Credencial credencial) throws SQLException {
        String sql = "INSERT INTO credenciales(id_usuario, username, pass, permiso) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setInt(1, credencial.getId_usuario());
            pstmt.setString(2, credencial.getUsername());
            pstmt.setString(3, credencial.getPassword());
            pstmt.setString(4, credencial.getPermiso().toString());

            pstmt.executeUpdate();

            // Retorna el ultimo ID ingresado a la tabla (solo funciona inmediatamente despues de un INSERT)
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() AS id_credencial;");
            if (rs.next())
                return rs.getInt("id_credencial");

            return -1;
        }
    }

    @Override
    public List<Credencial> listar() throws SQLException {
        String sql= "SELECT * FROM credenciales;";
        List<Credencial> credenciales = new ArrayList<>();

        try(Statement statement= conexionMySQL.createStatement()){
            ResultSet rt= statement.executeQuery(sql);

            while(rt.next()){
                credenciales.add(crearCredencial(rt));
            }
        }
        return credenciales;
    }

    @Override
    public Credencial obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM credenciales WHERE id_credencial = " + id + ";";

        try (Statement stm = conexionMySQL.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next())
                return crearCredencial(rs);
        }

        return null;
    }

    @Override
    public void actualizar(Credencial nuevo) throws SQLException {
        String sql = "UPDATE credenciales SET id_usuario = ?, username = ?, password = ? WHERE id_credencial = ?;";

        try (PreparedStatement pstmt = conexionMySQL.prepareStatement(sql)) {
            pstmt.setInt(1, nuevo.getId_usuario());
            pstmt.setString(2, nuevo.getUsername());
            pstmt.setString(3, nuevo.getPassword());
            pstmt.setString(4, nuevo.getPermiso().toString());

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

    public static Credencial crearCredencial(ResultSet rt) throws SQLException{
        Credencial credencial= new Credencial();

        credencial.setId_credencial(rt.getInt("id_credencial"));
        credencial.setId_usuario(rt.getInt("id_usuario"));
        credencial.setUsername(rt.getString("username"));
        credencial.setPassword(rt.getString("pass"));
        credencial.setPermiso(Permisos.valueOf(rt.getString("permiso")));

        return credencial;
    }
}
