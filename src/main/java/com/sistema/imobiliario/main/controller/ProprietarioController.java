package com.sistema.imobiliario.main.controller;

import java.util.List;

import com.sistema.imobiliario.main.entity.Proprietario;
import com.sistema.imobiliario.main.service.ProprietarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProprietarioController {
    
    private ProprietarioService service;

    @Autowired
    public ProprietarioController(ProprietarioService service) {
        this.service = service;
    }

    @PostMapping("/salvarProprietario")
    public String salvarProprietario(@RequestBody Proprietario proprietario){
        return this.service.salvarProprietario(proprietario);
    }
    
    @GetMapping("/buscaProprietarios")
    public List<Proprietario> busProprietarios(){
        return this.service.buscaProprietario();
    }
}
