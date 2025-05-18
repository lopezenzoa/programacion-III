package controlador;

public class CambioEstadoInvalidoException extends RuntimeException {
    public CambioEstadoInvalidoException() {
        super("Estado invalido");
    }
}
