package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entidad.Evento;
import com.example.Service.EventoService;

@Controller
@RequestMapping("/eventos")   
public class EventoController {

    @Autowired
    private EventoService servicio;

    @GetMapping("/lista")
    public String listarEventos(Model modelo) {
        List<Evento> eventos = servicio.listarTodos(); 
        modelo.addAttribute("eventos", eventos);
        return "eventos/lista";  
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Long id, Model model) {
        Optional<Evento> evento = servicio.obtenerEventoPorId(id);
        if (evento.isEmpty()) {         
            return "redirect:/eventos/lista";
        }
        model.addAttribute("evento", evento.get());
        return "eventos/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Evento evento) {
        if (!id.equals(evento.getId())) {
            return "redirect:/eventos/lista?error=ID mismatch";
        }
        servicio.updateEvento(evento);
        return "redirect:/eventos/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        servicio.eliminarEvento(id);
        return "redirect:/eventos/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarNuevo(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario"; 
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        servicio.guardarEvento(evento);
        return "redirect:/eventos/lista";
    }

    @GetMapping
    public String home() {
        return "redirect:/eventos/lista";
    }
}