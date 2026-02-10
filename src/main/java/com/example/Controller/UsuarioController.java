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

import com.example.Entidad.Usuario;
import com.example.Service.UsuarioService;

@Controller
@RequestMapping("/usuario")   
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/lista")
    public String listarUsuarios(Model modelo) {
        List<Usuario> usuarios = servicio.listarTodos(); 
        modelo.addAttribute("usuarios", usuarios);
        return "usuario/lista";  
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = servicio.obtenerUsuarioPorId(id);
        if (usuario.isEmpty()) {         
            return "redirect:/usuario/lista";
        }
        model.addAttribute("usuario", usuario.get());
        return "usuario/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        if (!id.equals(usuario.getId())) {
            return "redirect:/usuario/lista?error=ID mismatch";
        }
        servicio.updateUsuario(usuario);
        return "redirect:/usuario/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        servicio.eliminarUsuario(id);
        return "redirect:/usuario/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formulario"; 
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        servicio.guardarUsuario(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping
    public String home() {
        return "redirect:/usuario/lista";
    }
}