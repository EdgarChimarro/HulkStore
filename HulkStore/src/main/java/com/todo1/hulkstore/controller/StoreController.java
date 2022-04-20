/**
 * 
 */
package com.todo1.hulkstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.engine.AttributeName;

import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.servicio.IProductoDao;
import com.todo1.hulkstore.servicio.IRepositorioProducto;

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
    
    @GetMapping
    public String index(Model model, @PageableDefault(size = 3) Pageable pageable){
	Page<Producto> productos = productoDao.listarproductos(pageable);
	model.addAttribute("productos", productos);
	return "index";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model){
	model.addAttribute("productos", new Producto());
	return "form";
    }
    
    @PostMapping("/nuevo")
    public String crear(Producto producto) {
	productoDao.guardarProducto(producto);	
	return "redirect:/";	
    }
}
