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
	@Column(name = "email")
	private String email;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return this.genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "El evento" + this.nombre + ", email de contacto: " + this.email + ", totalmente definido como " + this.genero.toString();
		
	}
	
}
