/**
 * 
 */
package com.todo1.hulkstore.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Edgar Chimarro
 *
 */
@Data
@Table
@Entity
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_Producto;        
    private String nombre_Producto;
    private String descripcion_Producto;
    
    @Column(nullable = false)
    private float precio_Unitario;
    private int cantidad_Producto;    
    
    @Column(nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDateTime fecha_Registro;

    @PrePersist
    private void generarRegistro() {
	this.fecha_Registro = LocalDateTime.now();
    }

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public String getDescripcion_Producto() {
        return descripcion_Producto;
    }

    public void setDescripcion_Producto(String descripcion_Producto) {
        this.descripcion_Producto = descripcion_Producto;
    }

    public float getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(float precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public int getCantidad_Producto() {
        return cantidad_Producto;
    }

    public void setCantidad_Producto(int cantidad_Producto) {
        this.cantidad_Producto = cantidad_Producto;
    }

    public LocalDateTime getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(LocalDateTime fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }
        
}
