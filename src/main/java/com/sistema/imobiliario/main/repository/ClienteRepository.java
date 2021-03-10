package com.sistema.imobiliario.main.repository;

import java.util.Optional;

import com.sistema.imobiliario.main.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Cliente findByNomeAndEmail(String nome, String email);

	Optional<Cliente> findByEmailAndNome(String nome, String email);
    
}
