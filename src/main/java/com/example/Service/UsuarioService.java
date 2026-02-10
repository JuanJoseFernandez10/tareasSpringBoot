package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entidad.Usuario;
import com.example.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	

	public List<Usuario> listarTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Usuario> findByName(String name) {
		return repositorio.findByUsername(name);
	}

	public void guardarUsuario(Usuario usuario) {
		repositorio.save(usuario);	
	}
	
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);
	}
	
	public Optional<Usuario> obtenerUsuarioPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void updateUsuario(Usuario usuario) {
		repositorio.save(usuario);
	}
}
