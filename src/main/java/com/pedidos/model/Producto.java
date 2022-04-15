/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.model;

import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Winston
 */
public class Producto {

    @Id
    private Integer id;

    @NotBlank
    //@Field(type = FieldType.Text)
    private String nombre;

    public Producto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return "Producto: id="+this.id+"; Nombre producto: "+this.nombre;
    }    
}