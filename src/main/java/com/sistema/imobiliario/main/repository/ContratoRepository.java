package com.sistema.imobiliario.main.repository;

import com.sistema.imobiliario.main.entity.Contrato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer>{
    
}
