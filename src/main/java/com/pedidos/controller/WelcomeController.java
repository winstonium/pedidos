/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedidos.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Winston
 */
@RestController
public class WelcomeController {

    @Operation(summary="Servidor estado", tags = {"Bievenida"})
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String doIndex() {
        return "Servicio pedido de productos, iniciado...";
    }

}
