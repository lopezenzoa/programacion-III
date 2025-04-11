package model;

import controller.enums.TipoCuenta;

public class Cuenta {
    private int id_cuenta;
    private int id_usuario;
    private TipoCuenta tipo;
    private float saldo;

    public Cuenta() {
    }

    public Cuenta(int id_cuenta, int id_usuario, TipoCuenta tipo, float saldo) {
        this.id_cuenta = id_cuenta;
        this.id_usuario = id_usuario;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id_cuenta=" + id_cuenta +
                ", id_usuario=" + id_usuario +
                ", tipo=" + tipo +
                ", saldo=" + saldo +
                '}';
    }
}
