package com.sistema.imobiliario.main.service;

import com.sistema.imobiliario.main.entity.Imovel;
import com.sistema.imobiliario.main.entity.Proprietario;
import com.sistema.imobiliario.main.repository.ImovelRepository;
import com.sistema.imobiliario.main.repository.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {
    
    private ImovelRepository imovelRepositorio;
    private ProprietarioRepository proprietarioRepositorio;

    @Autowired
    public ImovelService(ImovelRepository iRepositorio, ProprietarioRepository pRepositorio) {
        this.imovelRepositorio = iRepositorio;
        this.proprietarioRepositorio = pRepositorio;
    }

    public String salvarImovel(Imovel imovel){
        Proprietario proprietario = this.proprietarioRepositorio.
        findByEmail(imovel.getProprietario().getEmail());

        if(proprietario != null){
            imovel.setProprietarioId(proprietario.getId());
            this.imovelRepositorio.save(imovel);
            return "sucesso";
        }else{
            return "proprietario não encontrado";
        }
        
    }
}
