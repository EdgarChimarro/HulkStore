/**
 * 
 */
package com.todo1.hulkstore.servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.Producto;

/**
 * @author Edgar Chimarro
 *
 */
@Repository
public interface IRepositorioProducto extends JpaRepository<Producto, Integer>{

}
