package com.delivery.myfood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column(name = "endereo_cep")
	private String cep;
	
	@Column(name = "endereo_logradouro")
	private String logradouro;
	
	@Column(name = "endereo_numero")
	private String numero;
	
	@Column(name = "endereo_complemento")
	private String complemento;
	
	@Column(name = "endereo_bairro")
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
	
}
