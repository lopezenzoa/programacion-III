package repositorio.interfaces;

import excepciones.MontoInvalidoException;
import excepciones.PagoRechazadoException;

import java.util.List;

public interface Operable<M> {
    String agregar(M pago) throws MontoInvalidoException, PagoRechazadoException;
    String eliminar(int id);
    List<M> mostrar();

}
