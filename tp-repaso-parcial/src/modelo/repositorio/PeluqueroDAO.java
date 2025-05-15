package modelo.repositorio;

import modelo.Peluquero;
import utils.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeluqueroDAO implements IRepositorio<Peluquero> {

    private Connection connection;

    public PeluqueroDAO(){
        this.connection= ConexionMySQL.getInstance().getConnection();
       crearTabla();
    }

    @Override
    public List<Peluquero> buscarTodos() {
        String sql= "SELECT * FROM peluquero;";
        List<Peluquero> peluqueros = new ArrayList<>();

        try(Statement statement= connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Peluquero peluquero = new Peluquero();
                peluquero.setId(rs.getInt("id"));
                peluquero.setNombre(rs.getString("nombre"));
                peluquero.setEspecialidad(rs.getString("especialidad"));

                peluqueros.add(peluquero);
            }

            return peluqueros;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Peluquero> buscarPorId(int id) {
    String sql= "SELECT * FROM peluquero WHERE id = " + id + ";";

        try(Statement statement=connection.createStatement()){
        ResultSet rs= statement.executeQuery(sql);

            Peluquero peluquero=new Peluquero();

            if(rs.next()){
            peluquero.setId(rs.getInt("id"));
            peluquero.setNombre(rs.getString("nombre"));
            peluquero.setEspecialidad(rs.getString("especialidad"));

            return Optional.of(peluquero);
        }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Peluquero> guardar(Peluquero peluquero) {
        String sql= "INSERT INTO peluquero(nombre, especialidad) VALUES(?,?);";

        try(PreparedStatement prepareStatement= connection.prepareStatement(sql)){
            prepareStatement.setString(1, peluquero.getNombre());
            prepareStatement.setString(2, peluquero.getEspecialidad());

            prepareStatement.execute();

            ResultSet  rs = prepareStatement.executeQuery("SELECT LAST_INSERT_ID() AS id;");

            if(rs.next()){
                peluquero.setId(rs.getInt("id"));
            }
            return Optional.of(peluquero);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean actualizar(Peluquero nuevoPeluquero) {
        String sql= "UPDATE peluquero SET nombre = ? , especialidad = ? WHERE id = ? ;";

        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setString(1, nuevoPeluquero.getNombre());
            preparedStatement.setString(2, nuevoPeluquero.getEspecialidad());

            preparedStatement.setInt(3, nuevoPeluquero.getId());

            // ejecuta la actualizacion de la db
            // execute -> retorna false cuando se hace una actualizacion
            return !preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminarPorId(int id) {
        String sql= "DELETE peluquero WHERE id= " + id + ";";

        try(Statement statement= connection.createStatement()){
            int eliminado= statement.executeUpdate(sql);

            if(eliminado != 0){
                return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public void crearTabla(){
        String sql= "CREATE TABLE peluquero (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "nombre VARCHAR(100) NOT NULL,\n" +
                "especialidad VARCHAR(50)\n" +
                ");";

        try(Statement statement= connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
