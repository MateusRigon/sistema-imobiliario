package com.sistema.imobiliario.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Contrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String dataInicio;

    @Column(nullable = false)
    private String dataFim;
    
    @Column(nullable = false)
    private String taxaAdministracao;

    @Column(nullable = false)
    private String valorAluguel;

    @Column(nullable = false)
    private String valorCondominio;

    @Column(nullable = false)
    private String valorIptu;

    @Column(nullable = false)
    private int clienteId;

    @Column(nullable = false)
    private int proprietarioId;

    @Column(nullable = false)
    private int imovelId;

    @OneToMany(mappedBy = "contrato" ,cascade = CascadeType.ALL)
    private List<Mensalidade> mensalidade;

    private transient Cliente cliente;
    private transient Proprietario proprietario;
    private transient Imovel imovel;

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getTaxaAdministracao() {
        return taxaAdministracao;
    }

    public void setTaxaAdministracao(String taxaAdministracao) {
        this.taxaAdministracao = taxaAdministracao;
    }

    public String getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(String valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(String valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public String getValorIptu() {
        return valorIptu;
    }

    public void setValorIptu(String valorIptu) {
        this.valorIptu = valorIptu;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public int getImovelId() {
        return imovelId;
    }

    public void setImovelId(int imovelId) {
        this.imovelId = imovelId;
    }

    public List<Mensalidade> getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(List<Mensalidade> mensalidade) {
        this.mensalidade = mensalidade;
    }

}
