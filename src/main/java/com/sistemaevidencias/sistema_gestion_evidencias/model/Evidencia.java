package com.sistemaevidencias.sistema_gestion_evidencias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String moduloSeguridad; // Ej: Phishing, Vishing, Contraseñas
    private String categoria;        // Ej: Evaluación, Material Preventivo, Asistencia
    private String descripcion;
    private String urlArchivo;
    private LocalDate fechaRegistro;

    public Evidencia() {
        this.fechaRegistro = LocalDate.now(); // Asigna la fecha actual automáticamente
    }

    public Evidencia(String titulo, String moduloSeguridad, String categoria, String descripcion, String urlArchivo) {
        this.titulo = titulo;
        this.moduloSeguridad = moduloSeguridad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.urlArchivo = urlArchivo;
        this.fechaRegistro = LocalDate.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModuloSeguridad() {
        return moduloSeguridad;
    }

    public void setModuloSeguridad(String moduloSeguridad) {
        this.moduloSeguridad = moduloSeguridad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}