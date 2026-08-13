package com.pi.unileste.pmoc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String cep;
	@NotNull
	private Integer numero;
	@OneToOne
	@JoinColumn(name = "cpf_pessoa")
	private Pessoa pessoa;
	@NotNull
	private String cidade;
	@NotNull
	private String estado;
	
	public Endereco(@NotNull String cep, @NotNull Integer numero, Pessoa pessoa,
			@NotNull String cidade, @NotNull String estado) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.pessoa = pessoa;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
