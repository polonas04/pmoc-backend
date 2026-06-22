package com.pi.unileste.pmoc.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pessoa {

	@Id
	@NotNull
	private String cpf;
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotNull
	@Column(name ="dataNasc")
	private LocalDate dataNasc;
	
	public Pessoa() {
		
	}
	
	public Pessoa(@NotNull String cpf, @NotBlank String nome, @NotBlank String telefone,
			@NotNull LocalDate dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

}
