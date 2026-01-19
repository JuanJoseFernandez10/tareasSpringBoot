package com.example.Entidad;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "names")
	private String nombre;
	@Column(name = "genero")
	private Genero genero;
	@Column(name = "fecha-inicio")
	private Date fechaIncio;
	
	
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
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Date getFechaIncio() {
		return fechaIncio;
	}
	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}
	
	@Override
	public String toString() {
		return "El evento" + this.nombre + ", empieza el " + this.fechaIncio.toString() + ", totalmente definido como " + this.genero.toString();
	}
	
}
