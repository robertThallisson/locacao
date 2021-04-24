package com.locacao.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locacao.except.LocacaoException;
import com.locacao.model.Locacao;
import com.locacao.repository.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	public Locacao salvar(Locacao locacao) {
		if (locacaoRepository.veiculoDisponivel(locacao.getVeiculo().getId()) > 0) {
			throw new LocacaoException("Veiculo não esta diponivel para locação");
		}
		long dias = ChronoUnit.DAYS.between(locacao.getDataRetirada(), locacao.getDataPrevisao());
		locacao.setValorLocacao(dias * locacao.getVeiculo().getValorDiaria());

		if (locacao.getId() == null || locacao.getId() == 0) {
			locacao.setRecebido(false);
		}
		return locacaoRepository.save(locacao);
	}

	public Locacao receber(Locacao locacao) {
		if (locacao.getId() == null || locacao.getId() == 0) {
			throw new LocacaoException(" não e possivel receber locaçoes que não foram registradass"); 
		}
		if ((locacao.getRecebido() != null && locacao.getRecebido()) && locacao.getDataDevolucao() == null) {
			throw new LocacaoException(" não e possivel receber veiculos que nao estejam devolvidos"); 
		}
		
		if (locacao.getDataDevolucao() != null) {
			long dias = ChronoUnit.DAYS.between(locacao.getDataPrevisao(), locacao.getDataDevolucao());
			locacao.setValorMulta(dias * locacao.getVeiculo().getValorDiaria());
		}
		if (locacao.getValorMulta() != null) {
			locacao.setValorTotal(locacao.getValorMulta() + locacao.getValorLocacao());
		} else {
			locacao.setValorTotal(locacao.getValorLocacao());
		}
		return locacaoRepository.save(locacao);
	}
	
	public List<Locacao> getAll() {
		return locacaoRepository.findAll();
	}
	

	public void deletar(Locacao locacao) {
		locacaoRepository.delete(locacao);
	}

}
