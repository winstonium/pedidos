/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Winston
 */
public class Pedido {

    @Id
    private Integer id;

    @NotBlank
    //@Field(type = FieldType.Text)
    private Date fecha;
    private String descripcion;
    
    private List<Producto> productos=new ArrayList<>();
    

    public Pedido(Integer id, Date fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
        
    public String toString() {
        return "Pedido: id="+this.id+"; Descripcion: "+this.descripcion+"; Fecha: "+this.fecha.toString();
    }

    
}