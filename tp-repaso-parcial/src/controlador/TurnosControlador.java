package controlador;

import enums.Estados;
import excepciones.TurnoInvalidoException;
import modelo.Peluquero;
import modelo.Turno;
import modelo.repositorio.TurnoDAO;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TurnosControlador {
    private ClienteControlador cCliente;
    private PeluqueroControlador cPeluquero;
    private TurnoDAO repositorio;

    public TurnosControlador(TurnoDAO repositorio, ClienteControlador cCliente, PeluqueroControlador cPeluquero) {
        this.repositorio = repositorio;
        this.cCliente = cCliente;
        this.cPeluquero = cPeluquero;
    }


    public Turno buscarPorId(int id){
        Optional<Turno> turnoOptional = repositorio.buscarPorId(id);

        if(turnoOptional.isEmpty()){
            throw new RuntimeException("No se encontro el turno con el id " + id);
        }
        return turnoOptional.orElse(null);
    }



    public void registrarTurno(Integer clienteId, Integer peluqueroId, LocalDateTime fechaHora, String servicio){
        Turno turno= new Turno();

        turno.setClienteId(clienteId);
        turno.setPeluqueroId(peluqueroId);
        turno.setFechaHora(fechaHora);
        turno.setServicio(servicio);
        turno.setEstado(Estados.PENDIENTE);

        // Al registrar un turno, validar que:
        // - El cliente y el peluquero existan.
        // - El servicio no sea nulo o vacío.
        // - No exista otro turno en la misma fecha y hora para ese peluquero.
        // - La fecha no sea anterior a la actual.
        if (cCliente.validarCliente(clienteId) &&
                cPeluquero.validarPeluquero(peluqueroId) &&
                !servicio.isEmpty() &&
                fechaHora.isAfter(LocalDateTime.now()) &&
                validarTurno(fechaHora, peluqueroId)
        ) {
            repositorio.guardar(turno);
            System.out.println("El turno se ha registrado correctamente!");
        } else
            throw new TurnoInvalidoException();
    }

    public List<Turno> buscarTurnosPorPeluquero(Integer peluqueroId){
        return repositorio.buscarTodos()
                .stream()
                .filter(t -> t.getPeluqueroId().equals(peluqueroId)).toList();
    }

    public boolean validarTurno(LocalDateTime fechaHora, Integer peluqueroId) {
        List<Turno> turnos = buscarTurnosPorPeluquero(peluqueroId);

        // retorna si no hay ningun match en base al parametro fechaHora
        return turnos.stream()
                .noneMatch(t -> t.getFechaHora().equals(fechaHora));
    }

    public List<Turno> buscarTurnosFuturosPorPeluqero(Integer peluqueroId){
        return repositorio.buscarTodos()
                .stream().filter(t ->
                    t.getPeluqueroId().equals(peluqueroId) &&
                    t.getFechaHora().isAfter(LocalDateTime.now())
                ).toList();
    }

    public void modificarEstado(Integer id, Estados nuevoEstado){
        Turno turno = buscarPorId(id);

        if (turno.getEstado().equals(Estados.PENDIENTE) && nuevoEstado.equals(Estados.REALIZADO)) {
            turno.setEstado(nuevoEstado);
            repositorio.actualizar(turno);
        } else if (turno.getEstado().equals(Estados.PENDIENTE) && nuevoEstado.equals(Estados.CANCELADO)) {
            turno.setEstado(nuevoEstado);
            repositorio.actualizar(turno);
        } else
            throw new CambioEstadoInvalidoException();

        System.out.println("El turno se ha actualizado correctamente!");
    }
}
