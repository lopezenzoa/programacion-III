package controller;

import model.Paciente;
import view.PacienteView;

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

    public void agregarPaciente(PacienteController pacienteController) {
        if (!listadoPacientes.contains(pacienteController.getModel())) {
            listadoPacientes.add(pacienteController.getModel());
            pacienteController.mostrarPaciente();
        }
    }

    // El código que proporcionas puede funcionar, pero puede ser más flexible y cumplir con mejores prácticas al seguir principios de diseño como el Principio de Responsabilidad Única, la Inyección de Dependencias y la Prueba Unitaria.
    public void atenderPaciente() {
        PacienteController pacienteController = new PacienteController(listadoPacientes.poll(), new PacienteView());
        pacienteController.mostrarPaciente();
    }

    public void mostrarSiguientePaciente() {
        PacienteController pacienteController = new PacienteController(listadoPacientes.peek(), new PacienteView());
        pacienteController.mostrarPaciente();
    }
}
