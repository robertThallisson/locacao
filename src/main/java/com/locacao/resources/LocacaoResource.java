package com.locacao.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.locacao.model.Locacao;
import com.locacao.service.LocacaoService;

@RestController     
@RequestMapping("/locacao") 
public class LocacaoResource {

	@Autowired 
	private LocacaoService locacaoService;
	@PostMapping     
	public @ResponseBody ResponseEntity<Locacao>  salvar(@Valid @RequestBody Locacao locacao) {        
		return ResponseEntity.ok(locacaoService.salvar(locacao));   
	}     
	
	@PutMapping     
	public @ResponseBody ResponseEntity<Locacao>  receber(@Valid @RequestBody Locacao locacao) {        
		return ResponseEntity.ok(locacaoService.receber(locacao));   
	}  
	
	@GetMapping     
	public @ResponseBody ResponseEntity<List<Locacao>>  getAll() {        
		return ResponseEntity.ok(locacaoService.getAll());   
	} 
	
	@DeleteMapping     
	public @ResponseBody ResponseEntity<Locacao>   deletar(@Valid @RequestBody Locacao locacao) {      
		locacaoService.deletar(locacao);
		return ResponseEntity.ok(locacao);   
	} 
}
