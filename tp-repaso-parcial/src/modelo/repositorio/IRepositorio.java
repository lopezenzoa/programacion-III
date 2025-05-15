package modelo.repositorio;

import java.util.List;
import java.util.Optional;

public interface IRepositorio<T> {
    List<T> buscarTodos();
    Optional<T> buscarPorId(int id);
    Optional<T> guardar(T objeto);
    boolean actualizar(T nuevoObjeto);
    boolean eliminarPorId(int id);
}
