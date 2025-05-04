package com.prog.tp_mascotas.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Cuidador {
    private int cuidador_id;

    private String nombre;
    private String apellido;

    @NotBlank(message = "El email no puede ser un campo vacio")
    @Email(message = "El email no es valido")
    private String email;

    @NotBlank(message = "La dirección no puede ser un campo vacio")
    private String direccion;

    public Cuidador() {
    }

    public Cuidador(int cuidador_id, String nombre, String apellido, String email, String direccion) {
        this.cuidador_id = cuidador_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
    }

    public int getCuidador_id() {
        return cuidador_id;
    }

    public void setCuidador_id(int cuidador_id) {
        this.cuidador_id = cuidador_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
