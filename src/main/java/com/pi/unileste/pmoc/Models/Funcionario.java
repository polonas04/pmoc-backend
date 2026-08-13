package com.pi.unileste.pmoc.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Funcionario {

	@Id
	@NotNull
	private String matricula;
	@NotNull
	private String senha;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf_pessoa")
	private Pessoa pessoa;
	@NotNull
	private Integer ativo;
	
	public Funcionario(@NotNull String matricula, @NotNull String senha, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.pessoa = pessoa;
	}
	
	public Funcionario() {
		
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

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}	
	
}
