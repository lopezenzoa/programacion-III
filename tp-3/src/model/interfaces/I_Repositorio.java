package model.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface I_Repositorio<T> {
    void insertar(T t) throws SQLException;
    List<T> listar() throws SQLException;
    T obtenerPorId(int id) throws SQLException;
    void actualizar(T nuevo) throws SQLException;
    void eliminar(int id) throws SQLException;
}
