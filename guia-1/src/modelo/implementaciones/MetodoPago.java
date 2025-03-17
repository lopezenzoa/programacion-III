package modelo.implementaciones;

import modelo.interfaces.Pago;

public abstract class MetodoPago implements Pago {
    String fecha;
    String hora;
    String nombreConsumidor;
    String nombreDestinatario;
    double monto;
    int id;

    public MetodoPago(String fecha, String hora, String nombreConsumidor, String nombreDestinatario, double monto, int id) {
        this.fecha=  fecha;
        this.hora = hora;
        this.nombreConsumidor = nombreConsumidor;
        this.nombreDestinatario = nombreDestinatario;
        this.monto = monto;
        this.id = id;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getHora() {
        return hora;
    }

    @Override
    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String getNombreConsumidor() {
        return nombreConsumidor;
    }

    @Override
    public void setNombreConsumidor(String nombreConsumidor) {
        this.nombreConsumidor = nombreConsumidor;
    }

    @Override
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    @Override
    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MetodoPago{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", nombreConsumidor='" + nombreConsumidor + '\'' +
                ", nombreDestinatario='" + nombreDestinatario + '\'' +
                ", monto=" + monto +
                ", id=" + id +
                '}';
    }
}
