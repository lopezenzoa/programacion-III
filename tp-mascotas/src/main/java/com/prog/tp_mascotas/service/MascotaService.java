package com.prog.tp_mascotas.service;

import com.prog.tp_mascotas.model.Mascota;
import com.prog.tp_mascotas.repository.MascotaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IService<Mascota> {
    @Autowired
    private MascotaDAO mascotaDAO;

    @Override
    public List<Mascota> getAll() {return mascotaDAO.findAll();}
    @Override
    public Optional<Mascota> getById(int id) {return mascotaDAO.findById(id);}
    @Override
    public int save(Mascota mascota) {return mascotaDAO.save(mascota);}
    @Override
    public int update(Mascota nuevaMascota) {return mascotaDAO.update(nuevaMascota);}
    @Override
    public int deleteById(int id) {return mascotaDAO.deleteById(id);}
}
