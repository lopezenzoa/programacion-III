package UI;

import excepciones.MontoInvalidoException;
import excepciones.PagoRechazadoException;
import modelo.implementaciones.*;
import repositorio.implementaciones.RepositorioPagos;

public class Menu {
    public static RepositorioPagos repositorioPagos = new RepositorioPagos();

    public static void ejecutar() {
        // Agrega Pagos Fisicos
        Efectivo efectivo = new Efectivo("2025-17-3", "11:36", "Enzo", "Ailen", 3000, 1234, 0, "UTN MDP");
        Tarjeta tarjeta = new Tarjeta("2025-17-3", "11:36", "Enzo", "Ailen", 3000, 5678, "Credito", 83, 12, "UTN MDP");

        // Agrega Pagos Virtuales
        MercadoPago mercadoPago = new MercadoPago("2025-17-3", "11:36", "Enzo", "Ailen", 3000, 9012, "enzo@gmail.com", "0001111");
        Criptomoneda criptomoneda = new Criptomoneda("2025-17-3", "11:36", "Enzo", "Ailen", -1, 3456, "wallet_1234", "00001111");

        // Agregar transacciones
        try {
            repositorioPagos.agregar(efectivo);
            repositorioPagos.agregar(tarjeta);
            repositorioPagos.agregar(mercadoPago);
            repositorioPagos.agregar(criptomoneda);
        } catch (MontoInvalidoException | PagoRechazadoException e) {
            e.printStackTrace();
        }

        // Mostrar transacciones
        for (MetodoPago pago : repositorioPagos.mostrar())
            System.out.println(pago);

        // Eliminar transacciones
        repositorioPagos.eliminar(efectivo.getId());
        System.out.println();

        for (MetodoPago pago : repositorioPagos.mostrar())
            System.out.println(pago);
    }
}
