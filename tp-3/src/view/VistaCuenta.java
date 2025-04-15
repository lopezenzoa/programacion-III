package view;

import controller.enums.TipoCuenta;

public class VistaCuenta {
    public static void mostrarCuenta(int id_cuenta, int id_usuario, TipoCuenta tipoCuenta, float saldo) {
        System.out.println("----- Cuenta Información -----");
        System.out.println("ID Cuenta   : " + id_cuenta);
        System.out.println("ID Usuario  : " + id_usuario);
        System.out.println("Tipo Cuenta : " + tipoCuenta);
        System.out.println("Saldo       : $" + String.format("%.2f", saldo));
        System.out.println("------------------------------");
    }
}
