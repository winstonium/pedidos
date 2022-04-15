/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.service;

import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import java.util.List;

/**
 *
 * @author Winston
 */
public interface PedidosService {
    //Producto
    List<Producto> listadoProductos();
    String registrarProducto(Producto producto);
    String modificarProducto(Producto producto);
    String eliminarProducto(Integer id);
    //Pedidos
    List<Pedido> listadoPedidos();
    String registrarPedido(Pedido pedido);
    String modificarPedido(Pedido pedido);
    String eliminarPedido(Integer id);
    
    //Otras operaciones
    List<Producto> verProductosPorPedido(Integer id);
    List<Pedido> verPedidosDeProducto(Integer id);
}
