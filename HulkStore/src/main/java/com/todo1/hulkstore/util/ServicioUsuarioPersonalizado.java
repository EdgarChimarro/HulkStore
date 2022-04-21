package com.todo1.hulkstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.todo1.hulkstore.model.Usuario;
import com.todo1.hulkstore.servicio.IRepositorioUsuario;

public class ServicioUsuarioPersonalizado implements UserDetailsService {

    @Autowired
    private IRepositorioUsuario usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Usuario usuario = usuarioRepo.buscarPorEmail(email);
	if (usuario == null) {
	    throw new UsernameNotFoundException("Usuario no encontrado");
	}

	return new UsuarioPersonalizado(usuario);
    }

}
