package com.locacao.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@DynamicInsert
public class Locacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@Size(min = 8)
	private String email;
	
	@NotBlank
	@CPF(message = "CPF invalido")
	private String cpf;
		
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "data de retirada em branco")
	private LocalDate dataRetirada;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "data de previsao de entrega em branco")
	private LocalDate dataPrevisao;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao;
	
	@OneToOne
	private Veiculo  veiculo;
	
	private Float valorLocacao;
	private Float valorMulta;
	@Formula(" coalesce(valor_multa, 0) + valor_locacao ")
	private Float valorTotal;
	private Boolean recebido;
}
