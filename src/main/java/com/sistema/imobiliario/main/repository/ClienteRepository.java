package com.sistema.imobiliario.main.repository;

import com.sistema.imobiliario.main.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByNomeAndEmail(String nome, String email);
    
}
