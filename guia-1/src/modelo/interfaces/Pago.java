package modelo.interfaces;

public interface Pago {

    String getFecha();
    void setFecha(String fecha);
    String getHora();
    void setHora(String hora);
    String getNombreConsumidor();
    void setNombreConsumidor(String nombreConsumidor);
    String getNombreDestinatario();
    void setNombreDestinatario(String nombreDestinatario);
    double getMonto();
    void setMonto(double monto);
    int getId();
}
