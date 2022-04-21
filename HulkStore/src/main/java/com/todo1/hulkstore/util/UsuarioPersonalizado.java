/**
 * 
 */
package com.todo1.hulkstore.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.todo1.hulkstore.model.Usuario;

/**
 * @author Edgar Chimarro
 *
 */
public class UsuarioPersonalizado implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;

    public UsuarioPersonalizado(Usuario usuario) {
	this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

	return null;
    }

    @Override
    public String getPassword() {
	return usuario.getPassword();
    }

    @Override
    public String getUsername() {
	return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    public String getFullName() {
	return usuario.getNombre() + " " + usuario.getApellidos();
    }
}
