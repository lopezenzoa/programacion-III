package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private Connection connection;
    private static ConexionMySQL instancia;

    // datos para conectarse a la db
    private final String DB_NAME = "c3_LopezEnzo_tp_repaso";
    private final String URL = "jdbc:mysql://172.16.1.64:3306/" + DB_NAME;
    private final String USERNAME = "bdd1";
    private final String PASS = "bdd1";

    private ConexionMySQL() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConexionMySQL getInstance() {
        if (instancia == null)
            return new ConexionMySQL();

        return instancia;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
