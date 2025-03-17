package modelo.implementaciones;

import modelo.interfaces.PagoVirtual;

public class MercadoPago extends MetodoPago implements PagoVirtual {
    private String mail;
    private String ip;

    public MercadoPago(String fecha, String hora, String nombreConsumidor, String nombreDestinatario, double monto, int id, String mail,String ip){
        super(fecha, hora, nombreConsumidor, nombreDestinatario, monto, id);
        this.mail=mail;
        this.ip=ip;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
