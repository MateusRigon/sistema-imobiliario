package com.sistema.imobiliario.main.controller;

import com.sistema.imobiliario.main.entity.Contrato;
import com.sistema.imobiliario.main.service.ContratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContratoController {
    
    private ContratoService service;

    @Autowired
    public ContratoController(ContratoService service) {
        this.service = service;
    }

    @PostMapping("/salvarContrato")
    public String salvarContrato(@RequestBody Contrato contrato){
        return this.service.salvarContrato(contrato);
    }
}
