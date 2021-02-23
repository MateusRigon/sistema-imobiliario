package com.sistema.imobiliario.main.service;

import java.util.List;

import com.sistema.imobiliario.main.entity.Cliente;
import com.sistema.imobiliario.main.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    private ClienteRepository repositorio;

    @Autowired
    public ClienteService(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cliente> buscaClientes(){
        return this.repositorio.findAll();
    }

    public String salvarCliente(Cliente cliente){
        this.repositorio.save(cliente);
        return "sucesso";
    }

}
