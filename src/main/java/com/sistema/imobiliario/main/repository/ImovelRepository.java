package com.sistema.imobiliario.main.repository;

import com.sistema.imobiliario.main.entity.Imovel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer>{

	Imovel findByProprietarioIdAndEndereco(int id, String endereco);

    
}
