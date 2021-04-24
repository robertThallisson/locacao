package com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locacao.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	
}
