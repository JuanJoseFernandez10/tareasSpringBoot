package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entidad.Usuario;
import com.example.Service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public String listarEventos(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarTodos());
		return "usuario/lista";
	}
	
	@GetMapping("/eliminar")
	public String eliminarEvento(@ModelAttribute Usuario usuario) {
		servicio.eliminarUsuario(usuario);
		return "evento/lista";
	}
	
	@GetMapping("/guardar")
	public String guardarEvento(@ModelAttribute Usuario usuario) {
		servicio.guardarUsuario(usuario);
		return "evento/lista";
	}
	
	@GetMapping("/actualizar")
	public String actualizarEvento(@ModelAttribute Usuario usuario) {
		servicio.updateUsuario(usuario);
		return "evento/lista";
	}
}
