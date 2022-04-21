/**
 * 
 */
package com.todo1.hulkstore.servicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.todo1.hulkstore.model.Usuario;

/**
 * @author Edgar Chimarro
 *
 */
public interface IUsuarioDao {

    Usuario guardarUsuario(Usuario usuario);

    Optional<Usuario> obtenerUsuario(Long idUsuario);

    Usuario modificarUsuario(Long idUsuario, Usuario usuarioModificar);

    boolean eliminarUsuario(Long idUsuario);

    Page<Usuario> listarUsuario(Pageable pageable);

}
