package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/eliminar")
	public String eliminarEvento(@ModelAttribute Long id) {
		servicio.eliminarEvento(id);
		return "evento/lista";
	}
	
	@PostMapping("/guardar")
	public String guardarEvento(@ModelAttribute Evento evento) {
		servicio.guardarEvento(evento);
		return "evento/lista";
	}
	
	@PostMapping("/actualizar")
	public String actualizarEvento(@ModelAttribute Evento evento) {
		servicio.updateEvento(evento);
		return "evento/lista";
	}
	
}
