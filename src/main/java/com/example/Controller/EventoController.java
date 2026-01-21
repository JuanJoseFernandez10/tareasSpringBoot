package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
