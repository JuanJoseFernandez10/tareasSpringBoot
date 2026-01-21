package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entidad.Evento;
import com.example.Service.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService servicio;
	
	@GetMapping
	public String listarEventos(Model modelo) {
		modelo.addAttribute("eventos", servicio.listarTodos());
		return "eventos/lista";
	}
	
	@GetMapping("/eliminar")
	public String eliminarEvento(@ModelAttribute Evento evento) {
		servicio.eliminarEvento(evento);
		return "evento/lista";
	}
	
	@GetMapping("/guardar")
	public String guardarEvento(@ModelAttribute Evento evento) {
		servicio.guardarEvento(evento);
		return "evento/lista";
	}
	
}
