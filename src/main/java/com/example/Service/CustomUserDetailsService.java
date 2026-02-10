package com.example.Service;  

import com.example.Entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        String role = "ROLE_" + usuario.getRol().name();

        return User.withUsername(usuario.getUsername())
                   .password("{noop}" + usuario.getPassword())   
                   .authorities(role)
                   .accountExpired(false)
                   .accountLocked(false)
                   .credentialsExpired(false)
                   .disabled(false)
                   .build();
    }
}