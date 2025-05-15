package controlador;

import excepciones.ClienteNoEncontradoException;
import modelo.Cliente;
import modelo.repositorio.ClienteDAO;

import java.util.Optional;

public class ClienteControlador {
    private ClienteDAO repositorio;

    public ClienteControlador(ClienteDAO repositorio) {
        this.repositorio = repositorio;
    }

    public Cliente buscarPorId(int id) {
        Optional<Cliente> clienteOptional = repositorio.buscarPorId(id);

        if (clienteOptional.isEmpty())
            throw new ClienteNoEncontradoException(id);

        return clienteOptional.orElse(null);
    }

    public boolean insertar(Cliente cliente) {
        return repositorio.guardar(cliente).isPresent();
    }

    public boolean actualizar(Cliente nuevoCliente) {
        return repositorio.actualizar(nuevoCliente);
    }

    public boolean eliminar(int id) {
        return repositorio.eliminarPorId(id);
    }


}
