/**
 * 
 */
package com.todo1.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.model.Usuario;
import com.todo1.hulkstore.servicio.IProductoDao;
import com.todo1.hulkstore.servicio.IUsuarioDao;

import lombok.RequiredArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Controller
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @GetMapping("")
    public String inicio() {
	return "start";
    }

    @GetMapping("/index")
    public String index(Model model, @PageableDefault(size = 3) Pageable pageable) {
	Page<Producto> productos = productoDao.listarproductos(pageable);
	model.addAttribute("productos", productos);
	return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
	model.addAttribute("productos", new Producto());
	return "form";
    }

    @GetMapping("/registrar")
    public String registrarUsuario(Model model) {
	model.addAttribute("usuarios", new Usuario());
	return "registro";
    }

    @PostMapping("/procesar_registro")
    public String procesarRegistro(Usuario usuario) {
	usuarioDao.guardarUsuario(usuario);
	return "registroExitoso";
    }

    @PostMapping("/nuevo")
    public String crear(Producto producto) {
	productoDao.guardarProducto(producto);
	return "index";
    }
}
