package excepciones;

public class ClienteNoEncontradoException extends RuntimeException {
    public ClienteNoEncontradoException(int id) {
        super("El cliente con id: " + id + " no fue encontrado en la base de datos :(");
    }
}
