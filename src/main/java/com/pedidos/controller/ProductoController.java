/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.controller;

import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pedidos.service.PedidosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Winston
 */
@RestController
@RequestMapping(value = "/producto")
public class ProductoController {
    

    @Autowired
    PedidosService pedidosService;

    @Operation(summary = "Lista todos los productos", description = "Devuelve un listado de todos los productos disponibles.", tags = {"Listar productos"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @GetMapping("/lista")
    public List<Producto> listaProductos() {
        return pedidosService.listadoProductos();
    }
    
    
    @Operation(summary = "Registrar nuevo producto", description = "Registra un nuevo producto que es agregado a la lista de productos disponibles.", tags = {"Registrar producto"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrarProducto(
            @Parameter(description = "Parámetro permitido, tipo 'Producto', con los campos requeridos")
            @RequestBody Producto producto
    ){
        return pedidosService.registrarProducto(producto);
    }
    
    
    @Operation(summary = "Modificar  producto", description = "Modifica un producto que es parte de la lista de productos disponibles.", tags = {"Modificar producto"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public String modificarProducto(
            @Parameter(description = "Parámetro permitido, tipo 'Producto', con los campos requeridos")
            @RequestBody Producto producto
    ) {
        return pedidosService.modificarProducto(producto);
    }
    
    @Operation(summary = "Elimina  producto", description = "Elimina un producto que es parte de la lista de productos disponibles.", tags = {"Eliminar producto"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public String eliminarProducto(
            @NotNull @Parameter(description = "Id de producto", required = true)
            @PathVariable Integer id
    ) {
        return pedidosService.eliminarProducto(id);
    }
    
    
    /*Ver todos los Pediodos asignados a un Producto*/
    @Operation(summary = "Ver todos los Pedidos de un Producto", description = "Devuelve una lista de todos los Pedidos de un Producto.", tags = {"ver pedidos de producto"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/{id}/pedidos", method = RequestMethod.GET)
    public List<Pedido> verProductosPorPedido(
            @NotNull @Parameter(description = "Id de producto requerido", required = true)
            @PathVariable Integer id
    ){
        return pedidosService.verPedidosDeProducto(id);
    }
}
