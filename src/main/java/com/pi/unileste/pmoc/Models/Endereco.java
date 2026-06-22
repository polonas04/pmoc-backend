package com.pi.unileste.pmoc.Models;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

//@Entity
public class Endereco {

	@Id
	private Integer id;
	@NotNull
	private String cep;
	@NotNull
	private Integer numero;
	@NotNull
	private String cpf_Pessoa;
	@NotNull
	private String cidade;
	@NotNull
	private String estado;

	public Endereco(Integer id, @NotNull String cep, @NotNull Integer numero, @NotNull String cpf_Pessoa,
			@NotNull String cidade, @NotNull String estado) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.cpf_Pessoa = cpf_Pessoa;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getCpf_Pessoa() {
		return cpf_Pessoa;
	}

	public void setCpf_Pessoa(String cpf_Pessoa) {
		this.cpf_Pessoa = cpf_Pessoa;
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
