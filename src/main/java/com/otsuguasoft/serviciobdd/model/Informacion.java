package com.otsuguasoft.serviciobdd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbdd_informacion")
public class Informacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    public Informacion(String descripcion) {
        this.descripcion = descripcion;
    }
    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}