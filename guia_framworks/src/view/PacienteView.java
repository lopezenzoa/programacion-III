package view;

public class PacienteView {
    public PacienteView() {}

    public void imprimirDatosPaciente(String nombre, int prioridad) {
        System.out.println("Datos del paciente");
        System.out.println("\t" + nombre + " " + prioridad);
    }
}
