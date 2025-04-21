package model;

import controller.enums.Permisos;
import model.interfaces.I_Repositorio;
import model.util.ConexionMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public int insertar(Credencial credencial) throws SQLException {

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
        return null;
    }

    @Override
    public void actualizar(Credencial nuevo) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

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
