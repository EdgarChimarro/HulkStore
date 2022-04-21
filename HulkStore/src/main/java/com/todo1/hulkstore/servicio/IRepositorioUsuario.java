/**
 * 
 */
package com.todo1.hulkstore.servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.Usuario;

/**
 * @author Edgar Chimarro
 *
 */
@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM usuarios where email = :email")
    Usuario buscarPorEmail(@Param("email") String email);
}
