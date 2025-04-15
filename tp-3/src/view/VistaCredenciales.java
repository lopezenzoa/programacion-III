package view;

import controller.enums.Permisos;

public class VistaCredenciales {
    public static void mostrarCredenciales(int id_credencial, int id_usuario, String username, String password, Permisos permisos) {
        System.out.println("----- Credencial Información -----");
        System.out.println("ID Credencial : " + id_credencial);
        System.out.println("ID Usuario    : " + id_usuario);
        System.out.println("Username      : " + username);
        System.out.println("Password      : " + password);
        System.out.println("Permisos      : " + permisos);
        System.out.println("----------------------------------");
    }
}
