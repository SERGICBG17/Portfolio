package com.tu.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "lenguajes")
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre; // no nulo
    private String icono_url;

    public Lenguaje() {}

    public Lenguaje(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Lenguaje(long id, String nombre, String icono_url) {
        this.id = id;
        this.nombre = nombre;
        this.icono_url = icono_url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono_url() {
        return icono_url;
    }

    public void setIcono_url(String icono_url) {
        this.icono_url = icono_url;
    }
}
