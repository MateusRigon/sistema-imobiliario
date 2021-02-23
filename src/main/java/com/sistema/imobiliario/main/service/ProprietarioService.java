package com.sistema.imobiliario.main.service;

import java.util.List;
import java.util.Optional;

import com.sistema.imobiliario.main.entity.Proprietario;
import com.sistema.imobiliario.main.repository.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {
    
    private ProprietarioRepository repositorio;

    @Autowired
    public ProprietarioService(ProprietarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public String salvarProprietario(Proprietario p){
        Optional<Proprietario> proprietario  = this.repositorio.
        findByEmailAndNome(p.getEmail(), p.getNome());

        if (!proprietario.isPresent()) {
            this.repositorio.save(p);
            return "sucesso";
        } else {
            return "já cadastrado";            
        }
    }

    public List<Proprietario> buscaProprietario(){
        return this.repositorio.findAll();
    }
}
