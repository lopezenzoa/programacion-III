package com.prog.tp_mascotas.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    List<T> findAll();
    Optional<T> findById(int id);
    int save(T type);
    int update(T newType);
    int deleteById(int id);
}
