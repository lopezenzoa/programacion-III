package controlador;

import excepciones.ClienteNoEncontradoException;
import modelo.Cliente;
import modelo.repositorio.ClienteDAO;

import java.util.List;
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

    public boolean insertar(String nombre, String telefono, String email) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        return repositorio.guardar(cliente).isPresent();
    }

    public boolean actualizar(Integer id, String nombre, String telefono, String email) {
        Cliente cliente = buscarPorId(id);

        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        return repositorio.actualizar(cliente);
    }

    public boolean eliminar(int id) {
        return repositorio.eliminarPorId(id);
    }

    public boolean validarCliente(int clienteId) {
        return repositorio.buscarPorId(clienteId).isPresent();
    }
    public List<Cliente> listar() {
        return repositorio.buscarTodos();
    }
}
