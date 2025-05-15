package modelo.repositorio;

import modelo.Cliente;
import utils.ConexionMySQL;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO implements IRepositorio<Cliente> {
    private Connection connection;

    public ClienteDAO() {
        this.connection = ConexionMySQL.getInstance().getConnection();
        crearTabla();
    }

    @Override
    public List<Cliente> buscarTodos() {
        String sql = "SELECT * FROM cliente;";
        List<Cliente> clientes = new ArrayList<>();

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql); // executeQuery se usa para ejecutar consultas en la db

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));

                clientes.add(cliente);
            }

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = " + id + ";";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql); // executeQuery se usa para ejecutar consultas en la db

            Cliente cliente = new Cliente();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));

                return Optional.of(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Cliente> guardar(Cliente cliente) {
        String sql = "INSERT INTO cliente(nombre, telefono, email) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());

            // ejecuta la actualizacion de la db
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");

            if (rs.next())
                cliente.setId(rs.getInt("id"));

            return Optional.of(cliente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean actualizar(Cliente nuevoCliente) {
        String sql = "UPDATE cliente SET nombre = ?, telefono = ?, email = ? WHERE id = ?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nuevoCliente.getNombre());
            pstmt.setString(2, nuevoCliente.getTelefono());
            pstmt.setString(3, nuevoCliente.getEmail());

            // el id es igual para el nuevo cliente es el mismo que el viejo cliente
            pstmt.setInt(4, nuevoCliente.getId());

            // ejecuta la actualizacion de la db
            // execute -> retorna false cuando se hace una actualizacion
            return !pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminarPorId(int id) {
        String sql = "DELETE FROM cliente WHERE id = " + id + ";";

        try (Statement stmt = connection.createStatement()) {
            int eliminado = stmt.executeUpdate(sql);

            if (eliminado != 0)
                return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS cliente (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "nombre VARCHAR(100) NOT NULL,\n" +
                "telefono VARCHAR(20),\n" +
                "email VARCHAR(100)\n" +
                ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql); // executeUpdate se usa para actualizar la db
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
