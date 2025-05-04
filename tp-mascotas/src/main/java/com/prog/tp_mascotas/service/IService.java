package com.prog.tp_mascotas.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    int save(T type);
    int update(T newType);
    int deleteById(int id);
}
