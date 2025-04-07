import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DireccionDAO {
    Connection connection;
    public DireccionDAO() {
        this.connection = MySQLConexion.getInstancia().getConnection();
    }

    public boolean insertarDireccion (Direccion direccion){
        String query = "INSERT INTO direcciones(calle, altura, alumno_id) VALUES (?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, direccion.getCalle());
            statement.setInt(2, direccion.getAltura());
            statement.setInt(3, direccion.getId_alumno());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String verDireccion (int id){
        String query = "SELECT calle, altura FROM direcciones WHERE alumno_id= " + id + ";";
        try(PreparedStatement statement = connection.prepareStatement(query)){
           ResultSet respuesta = statement.executeQuery();

            String calle = null;
            int altura = 0;
           
           while (respuesta.next()) {
               calle = respuesta.getString("calle");
               altura = respuesta.getInt("altura");
           }
           
           return calle + " " + altura;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminarDireccion (int idDireccion){
        String query= "DELETE FROM direcciones WHERE id = " + idDireccion + ";";

        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
