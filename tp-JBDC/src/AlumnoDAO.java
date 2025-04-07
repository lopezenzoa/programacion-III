import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoDAO {
    Connection connection;

    public AlumnoDAO() {
        this.connection = MySQLConexion.getInstancia().getConnection();
    }

    public boolean insertarAlumno(Alumno alumno) {
        String query = "INSERT INTO alumnos(nombre, apellido, edad, email) VALUES (?, ?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellido());
            statement.setInt(3, alumno.getEdad());
            statement.setString(4, alumno.getEmail());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumnos;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet respuesta = statement.executeQuery();

            while (respuesta.next()) {
                Alumno alumno = new Alumno(
                        respuesta.getInt("id"),
                        respuesta.getString("nombre"),
                        respuesta.getString("apellido"),
                        respuesta.getInt("edad"),
                        respuesta.getString("email")
                );

                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public Map<Alumno, Direccion> listarAlumnosConDirecciones() {
        Map<Alumno, Direccion> alumnos = new HashMap<>();
        String query = "SELECT a.*, d.calle, d.altura FROM alumnos a\n" +
                "JOIN direcciones d\n" +
                "\tON a.id = d.alumno_id\n" +
                "GROUP BY a.id;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet respuesta = statement.executeQuery();

            while (respuesta.next()) {
                Alumno alumno = new Alumno(
                        respuesta.getInt("id"),
                        respuesta.getString("nombre"),
                        respuesta.getString("apellido"),
                        respuesta.getInt("edad"),
                        respuesta.getString("email")
                );

                Direccion direccion = new Direccion(
                        respuesta.getInt("id"),
                        respuesta.getString("calle"),
                        respuesta.getInt("altura"),
                        respuesta.getInt("id")
                );

                alumnos.put(alumno, direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public Alumno obtenerAlumno(int id){
        String query = "SELECT * FROM alumnos WHERE id = " + id + ";";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet respuesta = statement.executeQuery();

            while (respuesta.next()) {
                return new Alumno(
                        respuesta.getInt("id"),
                        respuesta.getString("nombre"),
                        respuesta.getString("apellido"),
                        respuesta.getInt("edad"),
                        respuesta.getString("email")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Alumno actualizarAlumno(int idAlumno, int nuevaEdad) {
        String query = "UPDATE alumnos SET edad = ? WHERE id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nuevaEdad);
            statement.setInt(2, idAlumno);

            statement.executeUpdate();

            return obtenerAlumno(idAlumno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean eliminarAlumno (int idAlumno){
        String query= "DELETE FROM alumnos WHERE id = " + idAlumno + ";";

        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
