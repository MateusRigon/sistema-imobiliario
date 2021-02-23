package com.sistema.imobiliario.main.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sistema.imobiliario.main.entity.Cliente;
import com.sistema.imobiliario.main.entity.Contrato;
import com.sistema.imobiliario.main.entity.Imovel;
import com.sistema.imobiliario.main.entity.Mensalidade;
import com.sistema.imobiliario.main.entity.Proprietario;
import com.sistema.imobiliario.main.repository.ClienteRepository;
import com.sistema.imobiliario.main.repository.ContratoRepository;
import com.sistema.imobiliario.main.repository.ImovelRepository;
import com.sistema.imobiliario.main.repository.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {
    
    private ContratoRepository contratoRepositorio;
    private ClienteRepository clienteRepositorio;
    private ProprietarioRepository proprietarioRepositorio;
    private ImovelRepository imovelRepositorio;

    @Autowired
    public ContratoService(ContratoRepository contratoRepositorio, ClienteRepository clienteRepositorio,
            ProprietarioRepository proprietarioRepositorio, ImovelRepository imovelRepositorio) {
        this.contratoRepositorio = contratoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.proprietarioRepositorio = proprietarioRepositorio;
        this.imovelRepositorio = imovelRepositorio;
    }

    public List<Contrato> buscaContratos(){
        return this.contratoRepositorio.findAll();
    }    

    public String salvarContrato(Contrato contrato){

        Cliente cliente = contrato.getCliente();
        Proprietario proprietario = contrato.getProprietario();
        Imovel imovel = contrato.getImovel();
        
        Cliente clienteExistente = this.clienteRepositorio.
        findByNomeAndEmail(cliente.getNome(), cliente.getEmail());

        Proprietario proprietarioExistente = this.proprietarioRepositorio.
        findByNomeAndEmail(proprietario.getNome(), proprietario.getEmail());

        Imovel imovelExistente = this.imovelRepositorio.
        findByProprietarioIdAndEndereco(proprietarioExistente.getId(), imovel.getEndereco());


        if (clienteExistente != null && proprietarioExistente != null
                && imovelExistente != null) {

            //seta id's

            contrato.setClienteId(clienteExistente.getId());
            contrato.setProprietarioId(proprietarioExistente.getId());
            contrato.setImovelId(imovelExistente.getId());
            
            //gera mensalidades
            
            int totalMensalidade = 12;
            List<Mensalidade> listaMensalidade = new ArrayList<>();

            for(int i = 1; i <= totalMensalidade; i++){
                Mensalidade mensalidade = new Mensalidade();
                mensalidade.setValorAluguel(contrato.getValorAluguel());
                mensalidade.setValorCondominio(contrato.getValorCondominio());
                mensalidade.setValorIptu(contrato.getValorIptu());
                mensalidade.setContrato(contrato);

                mensalidade.setDataCriacaoParcela(LocalDateTime.now());
                mensalidade.setDataVencimentoParcela(LocalDate.now(), i);

                listaMensalidade.add(mensalidade);
            }
            
            contrato.setMensalidade(listaMensalidade);
            this.contratoRepositorio.save(contrato);

            return "sucesso";
        } else {
            return "falhou";
        }
        
    }
}
