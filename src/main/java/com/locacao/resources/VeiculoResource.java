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

import com.locacao.model.Veiculo;
import com.locacao.service.VeiculoService;
@RestController     
@RequestMapping("/veiculo")  
public class VeiculoResource {
		
	@Autowired 
	private VeiculoService veiculoService;
	@PostMapping     
	public @ResponseBody ResponseEntity<Veiculo>  salvar(@Valid @RequestBody Veiculo veiculo) {        
		return ResponseEntity.ok(veiculoService.salvar(veiculo));   
	}     
	
	@PutMapping     
	public @ResponseBody ResponseEntity<Veiculo>  alterar(@Valid @RequestBody Veiculo veiculo) {        
		return ResponseEntity.ok(veiculoService.salvar(veiculo));   
	}  
	
	@GetMapping     
	public @ResponseBody ResponseEntity<List<Veiculo>>  getAll() {        
		return ResponseEntity.ok(veiculoService.getAll());   
	} 
	
	@DeleteMapping     
	public @ResponseBody ResponseEntity<Veiculo>   deletar(@Valid @RequestBody Veiculo veiculo) {      
		veiculoService.deletar(veiculo);
		return ResponseEntity.ok(veiculo);   
	} 
}
