package com.sistema.imobiliario.main.controller;

import com.sistema.imobiliario.main.entity.Imovel;
import com.sistema.imobiliario.main.service.ImovelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImovelController {
    
    private ImovelService service;

    @Autowired
    public ImovelController(ImovelService service) {
        this.service = service;
    }

    @PostMapping("/salvarImovel")
    public String salvarImovel(@RequestBody Imovel imovel){
        return this.service.salvarImovel(imovel);
    }
}
