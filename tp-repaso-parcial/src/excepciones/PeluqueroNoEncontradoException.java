package excepciones;

public class PeluqueroNoEncontradoException extends RuntimeException {
    public PeluqueroNoEncontradoException (int id){
        super("El peluquero con id: " + id + " no se encuentra en la base de datos :( ");
    }
}
