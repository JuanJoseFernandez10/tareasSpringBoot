package com.example.conf;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entidad.Evento;
import com.example.Entidad.Genero;
import com.example.Service.EventoService;
import com.github.javafaker.Faker;

public class InicializarDatos {

	@Autowired
	private EventoService servicio;
	
	public void run(String...args) throws Exception {
		 Faker faker = new Faker();

	        for (int i = 0; i < 10; i++) {
	            Evento evento = new Evento();
	            
	            evento.setNombre(faker.name().fullName());
	            evento.setGenero(Genero.ELECTRONICA);
	            evento.setFechaIncio(Date.valueOf("02 Feb 2026"));

	            servicio.guardarEvento(evento);
	        }
       

	}

}
