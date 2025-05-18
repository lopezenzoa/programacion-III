package controlador;

import excepciones.PeluqueroNoEncontradoException;
import modelo.Cliente;
import modelo.Peluquero;
import modelo.repositorio.PeluqueroDAO;

import java.util.List;
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

    public boolean insertar(String nombre, String especialidad) {
        Peluquero peluquero = new Peluquero();
        peluquero.setNombre(nombre);
        peluquero.setEspecialidad(especialidad);

        return repositorio.guardar(peluquero).isPresent();
    }
    public boolean actualizar(Integer id, String nombre, String especialidad) {
        // buscarmos el peluquero que queremos modificar
        Peluquero peluquero = buscarPorId(id);

        peluquero.setNombre(nombre);
        peluquero.setEspecialidad(especialidad);

        return repositorio.actualizar(peluquero);
    }

    public boolean eliminar(int id) {
        return repositorio.eliminarPorId(id);
    }

    public boolean validarPeluquero(int peluqueroId) {
        return repositorio.buscarPorId(peluqueroId).isPresent();
    }
    public List<Peluquero> listar() {
        return repositorio.buscarTodos();
    }
}
