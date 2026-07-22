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
    private String cantonLosRios;     // Babahoyo, Vinces, Quevedo, etc.
    private String moduloSeguridad;   // Phishing, Vishing, Smishing, Contraseñas
    private String categoria;         // Asistencia, Encuestas, Notas, Fotografías, Material
    private String detallePedagogico;  // Asistentes, Notas de exámenes o resultados
    private String descripcion;
    private String urlArchivo;
    private LocalDate fechaRegistro;

    public Evidencia() {
        this.fechaRegistro = LocalDate.now();
    }

    public Evidencia(String titulo, String cantonLosRios, String moduloSeguridad, String categoria, String detallePedagogico, String descripcion, String urlArchivo) {
        this.titulo = titulo;
        this.cantonLosRios = cantonLosRios;
        this.moduloSeguridad = moduloSeguridad;
        this.categoria = categoria;
        this.detallePedagogico = detallePedagogico;
        this.descripcion = descripcion;
        this.urlArchivo = urlArchivo;
        this.fechaRegistro = LocalDate.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCantonLosRios() { return cantonLosRios; }
    public void setCantonLosRios(String cantonLosRios) { this.cantonLosRios = cantonLosRios; }

    public String getModuloSeguridad() { return moduloSeguridad; }
    public void setModuloSeguridad(String moduloSeguridad) { this.moduloSeguridad = moduloSeguridad; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDetallePedagogico() { return detallePedagogico; }
    public void setDetallePedagogico(String detallePedagogico) { this.detallePedagogico = detallePedagogico; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUrlArchivo() { return urlArchivo; }
    public void setUrlArchivo(String urlArchivo) { this.urlArchivo = urlArchivo; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}