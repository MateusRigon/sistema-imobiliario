package com.sistema.imobiliario.main.controller;

import java.util.List;

import com.sistema.imobiliario.main.entity.Cliente;
import com.sistema.imobiliario.main.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    private ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/buscaClientes")
    public List<Cliente> buscaClientes(){
        return this.service.buscaClientes();
    }

    @PostMapping("/salvarCliente")
    public String salvarCliente(@RequestBody Cliente cliente){
        return this.service.salvarCliente(cliente);
    }
}
