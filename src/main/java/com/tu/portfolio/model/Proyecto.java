package com.tu.portfolio.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre; // no nulo
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String github_url;
    private String imagen_url;
    private LocalDate fecha;

    @ManyToMany
    @JoinTable(
            name = "proyecto_lenguaje",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "lenguaje_id")
    )
    List<Lenguaje> lenguajes;

    public Proyecto() {}

    public Proyecto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Proyecto(long id, String nombre, String descripcion, String github_url, String imagen_url, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.github_url = github_url;
        this.imagen_url = imagen_url;
        this.fecha = fecha;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithub_url() {
        return github_url;
    }

    public void setGithub_url(String github_url) {
        this.github_url = github_url;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }
}
