package controlador;

import excepciones.PeluqueroNoEncontradoException;
import modelo.Cliente;
import modelo.Peluquero;
import modelo.repositorio.PeluqueroDAO;

import java.util.Optional;

public class PeluqueroControlador {
    private PeluqueroDAO repositorio;

    public PeluqueroControlador(PeluqueroDAO repositorio){
        this.repositorio=repositorio;
    }

    public Peluquero buscarPorId (int id){
        Optional<Peluquero> peluqueroOptional= repositorio.buscarPorId(id);

        if(peluqueroOptional.isEmpty()) {
            throw new PeluqueroNoEncontradoException(id);
        }

        return peluqueroOptional.orElse(null);
    }

    public boolean insertar(Peluquero peluquero) {
        return repositorio.guardar(peluquero).isPresent();
    }
    public boolean actualizar(Peluquero nuevoPeluquero) {
        return repositorio.actualizar(nuevoPeluquero);
    }

    public boolean eliminar(int id) {
        return repositorio.eliminarPorId(id);
    }
}
