package repositorio.implementaciones;

import excepciones.MontoInvalidoException;
import excepciones.TarjetaVencidaException;
import modelo.implementaciones.MetodoPago;
import modelo.implementaciones.Tarjeta;
import repositorio.interfaces.Operable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RepositorioPagos implements Operable<MetodoPago> {
    Map<Integer, MetodoPago> pagos;

    public RepositorioPagos() {
        this.pagos = new HashMap<>();
    }

    public Map<Integer, MetodoPago> getPagos() {
        return pagos;
    }

    public void setPagos(Map<Integer, MetodoPago> pagos) {
        this.pagos = pagos;
    }

    @Override
    public boolean agregar(MetodoPago pago) throws MontoInvalidoException, TarjetaVencidaException {
        verificarMonto(pago.getMonto());

        if (pago instanceof Tarjeta)
            verificarVencimientoTarjeta(((Tarjeta) pago).getFechaVencimiento());

        pagos.put(pago.getId(),pago); // Si la ejecución llega a esta linea, entonces el pago no presenta ningun problema
        return true;
    }

    @Override
    public String eliminar(int id) {
        pagos.remove(id);
        return "Eliminado!";
    }

    @Override
    public List<MetodoPago> mostrar() {
        return new ArrayList<>(pagos.values());
    }

    public void verificarMonto(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto ingresado es invalido, ingresar un monto positivo!");
        }

    }

    public void verificarVencimientoTarjeta(String fechaVencimiento) throws TarjetaVencidaException {
        LocalDate fechaActual = LocalDate.now();
        LocalDate vencimiento = LocalDate.parse(fechaVencimiento);

        long diasDiferencia = ChronoUnit.DAYS.between(fechaActual, vencimiento);

        // Si la variable diasDiferencia es negativa, quiere decir que la fecha de vencimiento es mayor a la fecha actual
        if (diasDiferencia == 0 || diasDiferencia < 0) {
            throw new TarjetaVencidaException("La tarjeta de Crédito está vencida!");
        }
    }

    // Este metodo deberia verificar que todos los pagos agregados al mapa sean validos
    public String ejecutarPagos() {
        return "Ejecutando pagos...";
    }
}
