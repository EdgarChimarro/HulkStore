/**
 * 
 */
package com.todo1.hulkstore.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.model.Usuario;

import lombok.AllArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Service
@AllArgsConstructor
public class UsuarioDaoImpl implements IUsuarioDao {

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
	BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();
	String passwordCodificada = codificador.encode(usuario.getPassword());
	usuario.setPassword(passwordCodificada);
	return repositorioUsuario.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Long id) {
	return repositorioUsuario.findById(id);
    }

    @Override
    public Usuario modificarUsuario(Long idUsuario, Usuario usuarioModificar) {
	return repositorioUsuario.saveAndFlush(usuarioModificar);
    }

    @Override
    public boolean eliminarUsuario(Long idUsuario) {
	try {
	    repositorioUsuario.deleteById(idUsuario);
	    return true;
	} catch (Exception ex) {
	    ex.getMessage();
	    return false;
	}
    }

    @Override
    public Page<Usuario> listarUsuario(Pageable pageable) {
	return repositorioUsuario.findAll(pageable);
    }

}
