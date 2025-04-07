import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
    private static MySQLConexion instancia; // Se puede declarar un atributo que sea del tipo de la clase
    private final String DB_NAME = "C3_EnzoLopez_Programacion3";
    private final String URL = "jdbc:mysql://172.16.1.64:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
    private final String USERNAME = "bdd1";
    private final String PASS = "bdd1";
    private Connection connection;

    // UN constructor privado??
    private MySQLConexion() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static MySQLConexion getInstancia() {
        if (instancia == null) {
            return instancia = new MySQLConexion();
        } else {
            return instancia;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
