package modelo.repositorio;

import enums.Estados;
import modelo.Turno;
import utils.ConexionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnoDAO implements IRepositorio<Turno> {
    private Connection connection;

    public TurnoDAO() {
        this.connection = ConexionMySQL.getInstance().getConnection();
        // crearTabla()
    }

    @Override
    public List<Turno> buscarTodos() {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM turno";

        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Turno turno = new Turno();

                turno.setId(rs.getInt("id"));
                turno.setClienteId(rs.getInt("cliente_id"));
                turno.setPeluqueroId(rs.getInt("peluquero_id"));
                turno.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                turno.setServicio(rs.getString("servicio"));
                turno.setEstado(Estados.valueOf(rs.getString("estado")));

                turnos.add(turno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return turnos;
    }


    @Override
    public Optional<Turno> buscarPorId(int id) {
        String sql = "SELECT * FROM turno WHERE id = " + id + ";";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Turno turno = new Turno();

                turno.setId(rs.getInt("id"));
                turno.setClienteId(rs.getInt("cliente_id"));
                turno.setPeluqueroId(rs.getInt("peluquero_id"));
                turno.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                turno.setServicio(rs.getString("servicio"));
                turno.setEstado(Estados.valueOf(rs.getString("estado")));

                return Optional.of(turno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Turno> guardar(Turno turno) {
        String sql = "INSERT INTO turno (cliente_id, peluquero_id, fecha_hora, servicio, estado) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, turno.getClienteId());
            stmt.setInt(2, turno.getPeluqueroId());
            stmt.setTimestamp(3, Timestamp.valueOf(turno.getFechaHora()));
            stmt.setString(4, turno.getServicio());
            stmt.setString(5, turno.getEstado().name());

            stmt.execute();

            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");

            if (rs.next())
                turno.setId(rs.getInt("id"));

            return Optional.of(turno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean actualizar(Turno turno) {
        String sql = "UPDATE turno SET cliente_id = ?, peluquero_id = ?, fecha_hora = ?, servicio = ?, estado = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, turno.getClienteId());
            stmt.setInt(2, turno.getPeluqueroId());
            stmt.setTimestamp(3, Timestamp.valueOf(turno.getFechaHora()));
            stmt.setString(4, turno.getServicio());
            stmt.setString(5, turno.getEstado().name());
            stmt.setInt(6, turno.getId());

            return stmt.executeUpdate() > 0; // retorna la cantidad de filas actualizada
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean eliminarPorId(int id) {
        String sql = "DELETE FROM turno WHERE id = " + id + ";";

        try (Statement stmt = connection.createStatement()) {
            return stmt.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS turno (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "cliente_id INT NOT NULL,\n" +
                "peluquero_id INT NOT NULL,\n" +
                "fecha_hora DATETIME NOT NULL,\n" +
                "servicio VARCHAR(100) NOT NULL,\n" +
                "estado ENUM('PENDIENTE', 'REALIZADO', 'CANCELADO') DEFAULT 'PENDIENTE',\n" +
                "FOREIGN KEY (cliente_id) REFERENCES cliente(id),\n" +
                "FOREIGN KEY (peluquero_id) REFERENCES peluquero(id)\n" +
                ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
