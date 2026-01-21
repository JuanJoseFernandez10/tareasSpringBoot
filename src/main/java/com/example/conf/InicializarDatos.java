package com.example.conf;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Entidad.Evento;
import com.example.Entidad.Genero;
import com.example.Service.EventoService;
import com.github.javafaker.Faker;

@Component
public class InicializarDatos implements CommandLineRunner{

	@Autowired
	private EventoService servicio;
	
	@Override
	public void run(String...args) throws Exception {
		 Faker faker = new Faker();

	        for (int i = 0; i < 10; i++) {
	            Evento evento = new Evento();
	            
	            evento.setNombre(faker.name().fullName());
	            evento.setGenero(Genero.ELECTRONICA);
	            evento.setEmail(faker.funnyName() + "@gmail.com");

	            servicio.guardarEvento(evento);
	        }
       

	}

}
