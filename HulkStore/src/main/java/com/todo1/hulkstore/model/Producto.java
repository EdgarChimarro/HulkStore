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
    private Integer idProducto;        
    private String nombreProducto;
    private String descripcionProducto;
    
    @Column(nullable = false)
    private float precioUnitario;
    private int cantidadProducto;    
    
    @Column(nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDateTime fechaRegistro;

    @PrePersist
    private void generarRegistro() {
	this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer id_Producto) {
        this.idProducto = id_Producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombre_Producto) {
        this.nombreProducto = nombre_Producto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcion_Producto) {
        this.descripcionProducto = descripcion_Producto;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precio_Unitario) {
        this.precioUnitario = precio_Unitario;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidad_Producto) {
        this.cantidadProducto = cantidad_Producto;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fecha_Registro) {
        this.fechaRegistro = fecha_Registro;
    }
        
}
