package Excepciones;

public class IdentificadorDuplicadoException extends Exception {
    public IdentificadorDuplicadoException() {
        super("EL IDENTIFICADOR YA EXISTE EN EL REPOSITORIO");
    }
}
