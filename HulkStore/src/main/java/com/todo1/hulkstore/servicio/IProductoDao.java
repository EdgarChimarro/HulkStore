/**
 * 
 */
package com.todo1.hulkstore.servicio;

import java.util.List;

import com.todo1.hulkstore.model.Producto;

/**
 * @author Edgar Chimarro
 *
 */
public interface IProductoDao {

    Producto guardarProducto(Producto producto);
    
    Producto obtenerProducto(Integer idProducto);       
    
    Producto modificarUsuario(Integer idProducto, Producto productoModificar);
    
    boolean eliminarProducto(Integer idproducto);
    
    List<Producto> listarproductos();
    
}
