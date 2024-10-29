package com.matiasrojas.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "artistas")
public class Artista {
		
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "nombre", nullable = false)
	    private String nombre;

	    @Column(name = "apellido", nullable = false)
	    private String apellido;

	    @Column(name = "biografía",  nullable = true) 
	    private String biografía;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_creacion", nullable = false, updatable = false)
	    private Date fechaCreacion;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_actualizacion")
	    private Date fechaActualizacion;

	    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Cancion> canciones;

	    public Artista() {
	        this.fechaCreacion = new Date();
	        this.fechaActualizacion = new Date();
	    }

	    public Artista(String nombre, String apellido, String biografia) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.biografía = biografia;
	        this.fechaCreacion = new Date();
	        this.fechaActualizacion = new Date();
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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

	    public String getBiografia() {
	        return biografía;
	    }

	    public void setBiografia(String biografia) {
	        this.biografía = biografia;
	    }

	    public Date getFechaCreacion() {
	        return fechaCreacion;
	    }

	    public void setFechaCreacion(Date fechaCreacion) {
	        this.fechaCreacion = fechaCreacion;
	    }

	    public Date getFechaActualizacion() {
	        return fechaActualizacion;
	    }

	    public void setFechaActualizacion(Date fechaActualizacion) {
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public List<Cancion> getCanciones() {
	        return canciones;
	    }

	    public void setCanciones(List<Cancion> canciones) {
	        this.canciones = canciones;
	    }

}
