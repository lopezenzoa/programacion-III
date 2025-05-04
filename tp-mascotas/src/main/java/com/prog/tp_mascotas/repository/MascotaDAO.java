package com.prog.tp_mascotas.repository;

import com.prog.tp_mascotas.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaDAO implements IRepository<Mascota> {
    @Autowired // este bean se usa para inyectar las dependencias
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Mascota> findAll() {
        String sql = "SELECT * FROM mascotas;";

        // BeanPropertyRowMapper -> se usa para simplificar el mapeo de los registros a objetos Java (por medio de los getters y setters)
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mascota.class));
    }

    @Override
    public Optional<Mascota> findById(int id) {
        String sql = "SELECT * FROM mascotas WHERE mascota_id = ?;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Mascota.class), id));
    }

    @Override
    public int save(Mascota mascota) {
        String sql = "INSERT INTO mascotas(nombre, especie) VALUES (?, ?)";
        return jdbcTemplate.update(sql, mascota.getNombre(), mascota.getEspecie());
    }

    @Override
    public int update(Mascota nuevaMascota) {
        String sql = "UPDATE mascotas SET nombre = ?, especie = ? WHERE mascota_id = ?;";
        return jdbcTemplate.update(sql, nuevaMascota.getNombre(), nuevaMascota.getEspecie(), nuevaMascota.getMascota_id());
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM mascotas WHERE mascota_id = ?;";
        return jdbcTemplate.update(sql, id);
    }
}
