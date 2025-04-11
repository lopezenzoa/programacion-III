package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private final String URL = "jdbc:mysql://localhost:3306/tp_3";
    private final String USER = "root";
    private final String PASS = "root";

    private Connection myConn;
    private static ConexionMySQL instancia;

    // Constructor privado para evitar que otras clases inicializen la conexion
    // Establece la conexion con la base de datos
    private ConexionMySQL() throws SQLException {
        this.myConn = DriverManager.getConnection(URL, USER, PASS);
    }

    // Metodo publico para dar acceso a la instancia singleton
    public static ConexionMySQL getInstance() throws SQLException {
        if (instancia == null)
            return instancia = new ConexionMySQL();

        return instancia;
    }

    public Connection getConnection() {
        return myConn;
    }
}
