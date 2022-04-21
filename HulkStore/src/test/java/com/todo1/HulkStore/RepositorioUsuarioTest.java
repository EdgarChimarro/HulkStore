package com.todo1.HulkStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.todo1.hulkstore.model.Usuario;
import com.todo1.hulkstore.servicio.IRepositorioUsuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RepositorioUsuarioTest {

    @Autowired
    private IRepositorioUsuario repositorioUsuario;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void crearusuario() {
	Usuario usuario = new Usuario();
	usuario.setEmail("edgar@gmail.com");
	usuario.setPassword("edgar2021");
	usuario.setNombre("Edgar");
	usuario.setApellidos("Chimarro Trujillo");

	Usuario usuarioRegistrado = repositorioUsuario.save(usuario);

	Usuario usuarioExistente = entityManager.find(Usuario.class, usuarioRegistrado.getId());

	assertEquals(usuarioExistente.getEmail(), usuarioRegistrado.getEmail());

    }

    @Test
    public void buscarPorEmail() {
	Usuario usuario = new Usuario();
	usuario.setEmail("edgar@gmail.com");
	Usuario usuarioEncontrado = repositorioUsuario.buscarPorEmail(usuario.getEmail());
	System.out.println("Usuario:" + usuarioEncontrado.getEmail() + " ," + usuarioEncontrado.getNombre());
	assertNotNull(usuarioEncontrado);
    }

}
