package com.tu.portfolio.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;//no nulo
    private String descripcion;
    private String foto_url;
    private String email;//no nulo
    private String telefono;
    private String linkedin;
    private String github;

    public Info() {}

    public Info(long id, String nombre,String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Info(long id, String nombre, String descripcion, String foto_url, String email, String telefono, String linkedin, String github) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto_url = foto_url;
        this.email = email;
        this.telefono = telefono;
        this.linkedin = linkedin;
        this.github = github;
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

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
