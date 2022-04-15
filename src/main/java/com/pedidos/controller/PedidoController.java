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
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidosService pedidosService;
    
    @Operation(summary = "Lista todos los pedidos", description = "Devuelve un listado de todos los pedidos disponibles.", tags = {"Listar pedidos"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @GetMapping("/lista")
    public List<Pedido> listaPedidos() {
        return pedidosService.listadoPedidos();
    }
    
    @Operation(summary = "Registrar nuevo pedido", description = "Registra un nuevo pedido que es agregado a la lista de pedidos disponibles.", tags = {"Registrar pedido"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrarPedido(
            @Parameter(description = "Parámetro permitido, tipo 'Pedido', con los campos requeridos")
            @RequestBody Pedido pedido
    ){
        return pedidosService.registrarPedido(pedido);
    }
    
    @Operation(summary = "Modificar  pedido", description = "Modifica un pedido que es parte de la lista de pedidos disponibles.", tags = {"Modificar pedido"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public String modificarPedido(
            @Parameter(description = "Parámetro permitido, tipo 'Pedido', con los campos requeridos")
            @RequestBody Pedido pedido
    ){
        return pedidosService.modificarPedido(pedido);
    }
    
    @Operation(summary = "Elimina  pedido", description = "Elimina un pedido que es parte de la lista de pedidos disponibles.", tags = {"Eliminar pedido"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public String eliminarPedido(
            @NotNull @Parameter(description = "Id de pedido requerido", required = true)
            @PathVariable Integer id
    ){
        return pedidosService.eliminarPedido(id);
    }
    
    /*Ver todos los productos asignados a un pedido*/
    @Operation(summary = "Ver todos los Productos asignados a un Pedido", description = "Devuelve una lista de todos los Productos asignados a un Pedido.", tags = {"ver productos de pedido"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Solicitud realizada con éxito",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada")
    })
    @RequestMapping(value = "/{id}/productos", method = RequestMethod.GET)
    public List<Producto> verProductosPorPedido(
            @NotNull @Parameter(description = "Id de pedido requerido", required = true)
            @PathVariable Integer id
    ){
        return pedidosService.verProductosPorPedido(id);
    }
    
}
