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
import javax.persistence.Table;

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
    
    @Column(nullable = false)
    private String nombre_Producto;
    private String descripcion_Producto;
    
    @Column(nullable = false)
    private float precio_Unitario;
    private int cantidad_Max;
    private int cantidad_Min;
    
    @Column(nullable = false)
    private LocalDateTime fecha_registro;
    
}
