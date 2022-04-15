/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.service.impl;

import com.pedidos.model.Producto;
import com.pedidos.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.pedidos.service.PedidosService;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Winston
 */
@Service
public class PedidosServiceImpl implements PedidosService{
    //Logger logger; = (Logger) LoggerFactory.getLogger(PedidosServiceImpl.class);
    List<Producto> productos=new ArrayList<>();
    List<Pedido> pedidos=new ArrayList<>();

    public PedidosServiceImpl() {
        productos.add(new Producto(1,"Lapiz"));
        productos.add(new Producto(2,"Bolígrafo"));
        productos.add(new Producto(3,"Cuaderno"));
        productos.add(new Producto(4,"Marcador"));
        productos.add(new Producto(5,"Crayon"));
        productos.add(new Producto(6,"Resaltador"));
        
        
        pedidos.add(new Pedido(1, new Date(), "Pedido de materiales de Maria"));
        pedidos.add(new Pedido(2, new Date(), "Pedido de materiales de Juan"));
        pedidos.add(new Pedido(3, new Date(), "Pedido de materiales de Pedro"));
        //Maria
        pedidos.get(0).getProductos().add(productos.get(0));
        pedidos.get(0).getProductos().add(productos.get(1));
        pedidos.get(0).getProductos().add(productos.get(5));
        //Juan
        pedidos.get(1).getProductos().add(productos.get(3));
        //Pedro
        pedidos.get(2).getProductos().add(productos.get(0));
        pedidos.get(2).getProductos().add(productos.get(1));
        pedidos.get(2).getProductos().add(productos.get(2));
        pedidos.get(2).getProductos().add(productos.get(3));
        pedidos.get(2).getProductos().add(productos.get(5));
        
    }
    
    
    @Override
    public List<Producto> listadoProductos(){
        //logger.info("Listado de productos");
        List<Producto> lista = productos;
        return lista;
    }
    
    
    @Override
    public String registrarProducto(Producto producto){
        //logger.info("Registro de productos");
        productos.add(producto);
        return "Producto: "+producto.getNombre()+" fué agregado exitosamente";
    }
    
    @Override
    public String modificarProducto(Producto producto){
        //logger.info("Modificacion de productos");
        for (int i=0; i<productos.size();i++) {
            if(productos.get(i).getId().compareTo(producto.getId())==0){
                productos.set(i,producto);
                //logger.info("Producto modificado correctamente");
                return "Producto: "+producto.getNombre()+" modificado exitosamente";
            };
        }
        //logger.info("Producto no encontrado");
        return "No se encontró el producto: "+producto.getNombre();
    }
    
    @Override
    public String eliminarProducto(Integer id){
        //logger.info("Eliminación de productos");
        for (int i=0; i<productos.size();i++) {
            if(productos.get(i).getId().compareTo(id)==0){
                productos.remove(i);
                //logger.info("Producto eliminado correctamente");
                return "Producto ID: "+id+" fue eliminado exitosamente";
            };
        }
        //logger.warning("No se encontró el producto: "+id);
        return "No se encontró el producto: "+id;
    }


    /////////////////////////////PEDIDOS///////////////////////////////
    @Override
    public List<Pedido> listadoPedidos(){
        //logger.info("Listado de pedidos");
        List<Pedido> lista = pedidos;
        return lista;
    }
    
    
    @Override
    public String registrarPedido(Pedido pedido){
        //logger.info("registro de pedidos");
        pedidos.add(pedido);
        return "Pedido: "+pedido.getDescripcion()+", fué agregado exitosamente";
    }
    
    @Override
    public String modificarPedido(Pedido pedido){
        for (int i=0; i<pedidos.size();i++) {
            if(pedidos.get(i).getId().compareTo(pedido.getId())==0){
                pedidos.set(i,pedido);
                //logger.info("Pedido: "+pedido.getDescripcion()+", fué modificado exitosamente");
                return "Pedido: "+pedido.getDescripcion()+", fué modificado exitosamente";
            };
        }
        //logger.warning("No se encontró el pedido: "+pedido.getDescripcion());
        return "No se encontró el pedido: "+pedido.getDescripcion();
    }
    
    @Override
    public String eliminarPedido(Integer id){
        for (int i=0; i<pedidos.size();i++) {
            if(pedidos.get(i).getId().compareTo(id)==0){
                pedidos.remove(i);
                //logger.warning("Pedido ID: "+id+" fue eliminado exitosamente");
                return "Pedido ID: "+id+" fue eliminado exitosamente";
            };
        }
        //logger.warning("No se encontró el pedido: "+id);
        return "No se encontró el pedido: "+id;
    }
    
    @Override
    public List<Producto> verProductosPorPedido(Integer id){
        for (int i=0; i<pedidos.size();i++) {
            if(pedidos.get(i).getId().compareTo(id)==0){
                return pedidos.get(i).getProductos();
            };
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Pedido> verPedidosDeProducto(Integer id){
        List<Pedido> pedidosLista=new ArrayList<>();
        for (int i=0; i<pedidos.size();i++) {
            List<Producto> prods=pedidos.get(i).getProductos();
            for (int j=0; j<prods.size();j++) {
                if(prods.get(j).getId().compareTo(id)==0){
                    pedidosLista.add(pedidos.get(i));
                }
            }
        }
        return pedidosLista;
    }
}
