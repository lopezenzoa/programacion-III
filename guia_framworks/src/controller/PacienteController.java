package controller;

import model.Paciente;
import view.PacienteView;

public class PacienteController {
    private Paciente model;
    private PacienteView view;

    public Paciente getModel() {
        return model;
    }

    public void setModel(Paciente model) {
        this.model = model;
    }

    public PacienteController(Paciente model, PacienteView view) {
        this.model = model;
        this.view = view;
    }

    public void mostrarPaciente() {
        view.imprimirDatosPaciente(model.getNombre(), model.getPrioridad());
    }
}
