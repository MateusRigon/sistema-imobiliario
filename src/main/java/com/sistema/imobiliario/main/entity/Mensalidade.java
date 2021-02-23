package com.sistema.imobiliario.main.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Mensalidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String dataCriacaoParcela;

    @Column(nullable = false)
    private String dataVencimentoParcela;
    
    @Column(nullable = false)
    private boolean status = false;
    
    @Column(nullable = false)
    private String valorAluguel;

    @Column(nullable = false)
    private String valorCondominio;

    @Column(nullable = false)
    private String valorIptu;

    @ManyToOne()
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getDataCriacaoParcela() {
        return dataCriacaoParcela;
    }

    public void setDataCriacaoParcela(LocalDateTime dataCriacaoParcela) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm");
        String dataFormatada = dataCriacaoParcela.format(formatters);
        this.dataCriacaoParcela = dataFormatada;
    }

    public String getDataVencimentoParcela() {
        return dataVencimentoParcela;
    }

    public void setDataVencimentoParcela(LocalDate dataVencimento, int mesVencimento) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String dataFormatada = dataVencimento.plusMonths(mesVencimento).format(formatters);
        this.dataVencimentoParcela = dataFormatada;
    }
}
