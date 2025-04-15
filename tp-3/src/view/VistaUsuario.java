package view;

import model.Usuario;

public class VistaUsuario {
    public static void mostrarUsuario(int id, String nombre, String apellido, String dni, String email) {
        System.out.println("----- User Information -----");
        System.out.println("ID       : " + id);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Apellido : " + apellido);
        System.out.println("DNI      : " + dni);
        System.out.println("Email    : " + email);
        System.out.println("----------------------------");
    }
}
