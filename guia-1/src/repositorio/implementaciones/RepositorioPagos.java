package repositorio.implementaciones;

import excepciones.MontoInvalidoException;
import excepciones.PagoRechazadoException;
import modelo.implementaciones.MetodoPago;
import repositorio.interfaces.Operable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String agregar(MetodoPago pago) throws MontoInvalidoException, PagoRechazadoException {
        if (verificarMonto(pago.getMonto())) {
            pagos.put(pago.getId(),pago);
            return "Agregado!";
        }

        throw new PagoRechazadoException("El pago fue rechazado!");
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

    public boolean verificarMonto(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto ingresado es invalido, ingresar un monto positivo!");
        }

        return true;
    }
}
