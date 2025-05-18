package excepciones;

public class TurnoInvalidoException extends RuntimeException {
    public TurnoInvalidoException() {
        super("El turno no puede ser valido");
    }
}
