package com.locacao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locacao.model.Veiculo;
import com.locacao.repository.LocacaoRepository;
import com.locacao.repository.VeiculoRepository;

@Service    
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> getAll() {
		return veiculoRepository.findAll();
	}
	
	@Transactional
	public void deletar(Veiculo veiculo) {
		locacaoRepository.deleteByVeiculoId(veiculo.getId());
		veiculoRepository.delete(veiculo);
	}
}
