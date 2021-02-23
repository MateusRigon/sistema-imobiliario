package com.sistema.imobiliario.main.repository;

import java.util.Optional;

import com.sistema.imobiliario.main.entity.Proprietario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>{

	Proprietario findByEmail(String email);

	Optional<Proprietario> findByEmailAndNome(String email, String nome);

	Proprietario findByNomeAndEmail(String nome, String email);
    
}
