package modelo.implementaciones;

import excepciones.MontoInvalidoException;
import modelo.interfaces.PagoFisico;

public class Efectivo extends MetodoPago implements PagoFisico {
    private double vuelto;
    private String direccion;
    public Efectivo(String fecha, String hora, String nombreConsumidor, String nombreDestinatario, double monto, int id, double vuelto, String direccion) {
        super(fecha, hora, nombreConsumidor, nombreDestinatario, monto, id);
        this.vuelto = vuelto;
        this.direccion=direccion;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
