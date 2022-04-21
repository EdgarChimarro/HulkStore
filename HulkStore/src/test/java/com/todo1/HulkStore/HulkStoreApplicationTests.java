package com.todo1.HulkStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.servicio.IRepositorioProducto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class HulkStoreApplicationTests {

    @Autowired
    private IRepositorioProducto repositorioProducto;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void crearProducto() {
	Producto producto = new Producto();
	producto.setNombreProducto("Llavero Spiderman");
	producto.setDescripcionProducto("Llavero de Marvel");
	producto.setPrecioUnitario(new Float("12.5"));
	producto.setCantidadProducto(2);
	producto.setFechaRegistro(LocalDateTime.now());

	Producto productoRegistrado = repositorioProducto.save(producto);
	Producto productoExistente = entityManager.find(Producto.class, productoRegistrado.getIdProducto());

	assertEquals(productoExistente.getNombreProducto(), productoRegistrado.getNombreProducto());

    }

}
