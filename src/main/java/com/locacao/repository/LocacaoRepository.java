package com.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.locacao.model.Locacao;

public interface LocacaoRepository  extends JpaRepository<Locacao, Long> {
	@Transactional
 	@Query(value = "delete from locacao where veiculo_id = :id_veiculo", nativeQuery = true)
 	@Modifying
	void deleteByVeiculoId(@Param("id_veiculo")  Long id);
	
	@Query(value = "select count(*) from locacao where veiculo_id = :id_veiculo and recebido is false", nativeQuery = true)
	int veiculoDisponivel(@Param("id_veiculo")  Long id);
}
