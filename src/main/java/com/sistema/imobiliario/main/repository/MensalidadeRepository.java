package com.sistema.imobiliario.main.repository;

import com.sistema.imobiliario.main.entity.Mensalidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Integer>{
    
}
