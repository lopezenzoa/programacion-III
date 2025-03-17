package modelo.implementaciones;

import modelo.interfaces.PagoVirtual;

public class Criptomoneda extends MetodoPago implements PagoVirtual {
    private String idBilletera;
    private String ip;

    public Criptomoneda (String fecha, String hora, String nombreConsumidor, String nombreDestinatario, double monto, int id, String idBilletera, String ip){
        super(fecha, hora, nombreConsumidor, nombreDestinatario, monto, id);
        this.idBilletera=idBilletera;
        this.ip=ip;
    }

    public String getIdBilletera() {
        return idBilletera;
    }

    public void setIdBilletera(String idBilletera) {
        this.idBilletera = idBilletera;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

}
