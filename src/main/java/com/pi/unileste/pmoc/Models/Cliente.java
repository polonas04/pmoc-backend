package com.pi.unileste.pmoc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id
	@NotNull
	private String matricula;
	@NotNull
	private String senha;
	@OneToOne
	@JoinColumn(name = "cpf_pessoa")
	private Pessoa pessoa;
	
	public Cliente(@NotNull String matricula, @NotNull String senha, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.pessoa = pessoa;
	}
	
	public Cliente() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
