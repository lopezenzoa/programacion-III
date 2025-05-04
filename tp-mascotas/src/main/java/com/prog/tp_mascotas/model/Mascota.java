package com.prog.tp_mascotas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Mascota {
    private int mascota_id;

    // se definen @NotBlank y @Size para evitar que el atributo venga vacio o con pocos caracteres
    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, message = "El nombre de la mascota debe ser mayor a 3")
    private String nombre;

    @NotBlank(message = "La especie no puede estar vacia")
    @Size(min = 3, message = "La especie de la mascota debe ser mayor a 3")
    private String especie;

    public Mascota() {
    }

    public Mascota(int mascota_id, String nombre, String especie) {
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.especie = especie;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
