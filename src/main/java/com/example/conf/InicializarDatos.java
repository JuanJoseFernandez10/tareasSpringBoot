package com.example.conf;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Entidad.Evento;
import com.example.Entidad.Genero;
import com.example.Entidad.Rol;
import com.example.Entidad.Usuario;
import com.example.Service.EventoService;
import com.example.Service.UsuarioService;
import com.github.javafaker.Faker;

@Component
public class InicializarDatos implements CommandLineRunner{

	@Autowired
	private EventoService servicioEvento;
	@Autowired
	private UsuarioService servicioUsuario;
	
	@Override
	public void run(String...args) throws Exception {
		 Faker faker = new Faker();
		 	Usuario admin = new Usuario();
		 	admin.setUsername("administrador");
		 	admin.setPassword("admin123");
		 	admin.setRol(Rol.ADMIN);
		 	Usuario usuarioNormal = new Usuario();
		 	usuarioNormal.setUsername("usuario");
		 	usuarioNormal.setPassword("usuario");
		 	usuarioNormal.setRol(Rol.USER);
		 	servicioUsuario.guardarUsuario(usuarioNormal);
		 	servicioUsuario.guardarUsuario(admin);
	        for (int i = 0; i < 10; i++) {
	            Evento evento = new Evento();
	            Usuario user = new Usuario();
	            
	            evento.setNombre(faker.name().fullName());
	            evento.setGenero(Genero.ELECTRONICA);
	            evento.setEmail(faker.funnyName() + "@gmail.com");
	            
	            user.setUsername(faker.name().fullName());
	            user.setPassword(faker.animal().name());
	            user.setRol(Rol.USER);

	            servicioEvento.guardarEvento(evento);
	            servicioUsuario.guardarUsuario(user);
	        }
       

	}

}
