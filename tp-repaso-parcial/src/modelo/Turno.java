package modelo;

import enums.Estados;

import java.time.LocalDateTime;

public class Turno {
    private Integer id;
    private Integer clienteId;
    private Integer peluqueroId;
    private LocalDateTime fechaHora;
    private String servicio;
    private Estados estado;

    public Turno() {
    }

    public Turno(Integer id, Integer clienteId, Integer peluqueroId, LocalDateTime fechaHora, String servicio, Estados estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.peluqueroId = peluqueroId;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getPeluqueroId() {
        return peluqueroId;
    }

    public void setPeluqueroId(Integer peluqueroId) {
        this.peluqueroId = peluqueroId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
