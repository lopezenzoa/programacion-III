package modelo.implementaciones;

import modelo.interfaces.PagoFisico;

public class Tarjeta extends MetodoPago implements PagoFisico {
    private String tipo;
    private int numeroCuenta;
    private String fechaVencimiento;
    private int cantidadCuotas;
    private String direccion;


    public Tarjeta(String fecha, String hora, String nombreConsumidor, String nombreDestinatario, double monto, int id, String tipo, int numeroCuenta, String fechaVencimiento, int cantidadCuotas,String direccion) {
        super(fecha, hora, nombreConsumidor, nombreDestinatario, monto, id);
        this.tipo = tipo;
        this.numeroCuenta = numeroCuenta;
        this.fechaVencimiento = fechaVencimiento;
        definirCantidadCuotas(cantidadCuotas);
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void definirCantidadCuotas(int cantidadCuotas){
        if(tipo.compareTo("debito")==0) {
            setCantidadCuotas(0);
        } else {
            setCantidadCuotas(cantidadCuotas);
        }
    }
}
