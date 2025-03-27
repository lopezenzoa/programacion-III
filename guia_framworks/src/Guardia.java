import java.util.Comparator;
import java.util.PriorityQueue;

public class Guardia {
    private Comparator<Paciente> comparadorPaciente = (p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad());

    PriorityQueue<Paciente> listadoPacientes;

    public Guardia() {
         this.listadoPacientes = new PriorityQueue<>(comparadorPaciente);
    }

    public Comparator<Paciente> getComparadorPaciente() {
        return comparadorPaciente;
    }

    public void setComparadorPaciente(Comparator<Paciente> comparadorPaciente) {
        this.comparadorPaciente = comparadorPaciente;
    }

    public PriorityQueue<Paciente> getListadoPacientes() {
        return listadoPacientes;
    }

    public void setListadoPacientes(PriorityQueue<Paciente> listadoPacientes) {
        this.listadoPacientes = listadoPacientes;
    }

    public String agregarPaciente(Paciente paciente) {
        if (!listadoPacientes.contains(paciente)) {
            listadoPacientes.add(paciente);
            return "Paciente agregado" + "\n\t" + paciente;
        }

        return "Hubo un problema al agregar al paciente";
    }
}
