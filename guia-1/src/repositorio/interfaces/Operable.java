package repositorio.interfaces;

import excepciones.MontoInvalidoException;
import excepciones.TarjetaVencidaException;

import java.util.List;

public interface Operable<M> {
    boolean agregar(M pago) throws MontoInvalidoException, TarjetaVencidaException;
    String eliminar(int id);
    List<M> mostrar();
}
