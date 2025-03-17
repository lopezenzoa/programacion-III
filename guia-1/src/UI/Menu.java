package UI;

import excepciones.MontoInvalidoException;
import excepciones.TarjetaVencidaException;
import modelo.implementaciones.*;
import repositorio.implementaciones.RepositorioPagos;

public class Menu {
    public static RepositorioPagos repositorioPagos = new RepositorioPagos();

    public static void ejecutar() {
        // Instancio distintos metodos de pago
        Efectivo efectivo = new Efectivo("2025-03-17", "11:36", "Enzo", "Ailen", 3000, 1234, 0, "UTN MDP");
        Tarjeta tarjeta = new Tarjeta("2025-03-17", "11:36", "Enzo", "Ailen", 3000, 5678, "Credito", 83, "2025-03-18", 12, "UTN MDP");
        MercadoPago mercadoPago = new MercadoPago("2025-03-17", "11:36", "Enzo", "Ailen", 3000, 9012, "enzo@gmail.com", "0001111");
        Criptomoneda criptomoneda = new Criptomoneda("2025-03-17", "11:36", "Enzo", "Ailen", 3000, 3456, "wallet_1234", "00001111");

        // Mostrar transacciones
        /*
        for (MetodoPago pago : repositorioPagos.mostrar())
            System.out.println(pago);

         */

        // Agrego los metodos de pago al repositorio de pagos
        try {
            repositorioPagos.agregar(efectivo);
            repositorioPagos.agregar(tarjeta);
            repositorioPagos.agregar(mercadoPago);
            repositorioPagos.agregar(criptomoneda);

            // Se ejecuta la transacciones
            System.out.println(repositorioPagos.ejecutarPagos());
        } catch (MontoInvalidoException | TarjetaVencidaException e) {
            e.printStackTrace();
        }

        // Eliminar transacciones
        repositorioPagos.eliminar(efectivo.getId());
        System.out.println();

        /*
        for (MetodoPago pago : repositorioPagos.mostrar())
            System.out.println(pago);

         */
    }
}
