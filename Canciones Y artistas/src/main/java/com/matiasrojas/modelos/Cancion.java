package com.matiasrojas.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "canciones")
public class Cancion {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Size(min = 5, message = "Minimo 5 caracteres.")
	    @Column(nullable = false)
	    private String titulo;
	   
	    @ManyToOne
	    @JoinColumn(name = "artista", nullable = false)
	    private Artista artista;

	    @Size(min = 3, message = "Minimo 3 caracteres.")
	    @Column(nullable = false)
	    private String album;

	    @Size(min = 3, message = "Minimo 3 caracteres.")
	    @Column(nullable = false)
	    private String genero;

	    @Size(min = 3, message = "Minimo 3 caracteres.")
	    @Column(nullable = false)
	    private String idioma;

	    @Temporal(TemporalType.DATE)
		@Column(name="fecha_creacion")
		private Date fechaCreacion;
		
		@Temporal(TemporalType.DATE)
		@Column(name="fecha_actualizacion")
		private Date fechaActualizacion;

	public Cancion() {
	}
	
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

	    public Artista getArtista() {
	        return artista;
	    }

	    public void setArtista(Artista artista) {
	        this.artista = artista;
	    }

	    public String getAlbum() {
	        return album;
	    }

	    public void setAlbum(String album) {
	        this.album = album;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public String getIdioma() {
	        return idioma;
	    }

	    public void setIdioma(String idioma) {
	        this.idioma = idioma;
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


		@PrePersist
		protected void onCreate() {
			this.fechaCreacion = new Date();
			this.fechaActualizacion = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.fechaActualizacion = new Date();
	    }
}
