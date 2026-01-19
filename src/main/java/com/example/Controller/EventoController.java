package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Service.EventoService;

public class EventoController {

	@Autowired
	private EventoService servicio;
	
	@GetMapping("/listar")
	public String listarEventos(Model modelo) {
		modelo.addAttribute("evetnos", servicio.listarTodos());
		
		return "evetos/lista";
	}
	
}
