package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entidad.Evento;
import com.example.Repository.EventoRepository;


@Service
public class EventoService {

	@Autowired
	private EventoRepository repositorio;
	

	public List<Evento> listarTodos() {
		return repositorio.findAll();
	}
	
	/*public Evento encontrarEvento(String name) {
		return repositorio.);
	}*/

	public void guardarEvento(Evento evento) {
		repositorio.save(evento);	
	}
	
	public void eliminarEvento(Evento evento) {
		repositorio.delete(evento);
	}
	
	
}
