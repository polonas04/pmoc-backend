package DTOs;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class FuncionarioDTO {
	
	//Pessoa
	@NotNull
	private String cpf;
	@NotNull
	private String nome;
	@NotNull
	private String telefone;
	@NotNull
	private LocalDate data_nasc;
	
	//Funcionario
	@NotNull
	private String matricula;
	@NotNull
	private String senha;
	@NotNull
	private Integer ativo;
	
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
	public LocalDate getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
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
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	

}
