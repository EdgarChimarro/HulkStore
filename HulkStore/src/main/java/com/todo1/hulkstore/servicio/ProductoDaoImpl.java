/**
 * 
 */
package com.todo1.hulkstore.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.model.Producto;

import lombok.AllArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Service
@AllArgsConstructor
public class ProductoDaoImpl implements IProductoDao{

    @Autowired
    private IRepositorioProducto repositorioProducto;
    
    @Override
    public Producto guardarProducto(Producto producto) {	 
	return repositorioProducto.save(producto);
    }

    @Override
    public Producto obtenerProducto(Integer idProducto) {	
	return repositorioProducto.findById(idProducto).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Producto modificarUsuario(Integer idProducto, Producto productoModificar) {	
	return repositorioProducto.saveAndFlush(productoModificar);	
    }

    @Override
    public boolean eliminarProducto(Integer idproducto) {
	try {
	    repositorioProducto.deleteById(idproducto);
	    return true;
	} catch (Exception ex) {
	    ex.getMessage();
	    return false;
	}
    }

    @Override
    public Page<Producto> listarproductos(Pageable pageable) {
	return repositorioProducto.findAll(pageable);
    }

}
