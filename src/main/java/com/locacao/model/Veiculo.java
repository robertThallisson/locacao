package com.locacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 20, message = "marca deve ser menor que 20 caracteres")
	@NotBlank(message = "marca em branco")
	private String marca;
	
	@Size(max = 20, message = "modelo deve ser menor que 20 caracteres")
	@NotBlank(message = "marca em branco")
	private String modelo;
	
	@NotBlank(message = "cor em branco")
	@Size(max = 15, message = "marca deve ser menor que 15 caracteres")
	private String cor;
	
	@NotBlank(message = "placa em branco")
	@Size(max = 10, message = "marca deve ser menor que 10 caracteres")
	private String placa;
	
	@Formula("case when (select count(*) from locacao loc where loc.veiculo_id = id and loc.recebido = false) > 0 then 'alugado' else 'disponivel' end")
	private String status;
	
	private Float valorDiaria;
}
