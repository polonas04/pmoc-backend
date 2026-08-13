package com.pi.unileste.pmoc.Models;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Os")
public class Os {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate data_conclusao;
	private LocalDate data_atendimento;
	@NotNull
	private String descricao;
	@NotNull
	private Integer estado;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "matricula_cliente")
	private Cliente cliente;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_equipamento")
	private Equipamento equipamento;
	@ManyToOne
	@JoinColumn(name = "matricula_funcionario")
	private Funcionario funcionario;
	private Double valor_total;
	
	public Os(String descricao,
			Cliente cliente, Equipamento equipamento, Funcionario funcionario, Integer estado) {
		super();
		this.data_conclusao = null;
		this.data_atendimento = null;
		this.descricao = descricao;
		this.estado = estado;
		this.cliente = cliente;
		this.equipamento = equipamento;
		this.funcionario = funcionario;
		this.valor_total = 0.0;
	}
	
	public Os() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public LocalDate getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(LocalDate data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

	public LocalDate getData_atendimento() {
		return data_atendimento;
	}

	public void setData_atendimento(LocalDate data_atendimento) {
		this.data_atendimento = data_atendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Double getValorTotal() {
		return valor_total;
	}

	public void setValorTotal(Double valor_total) {
		this.valor_total = valor_total;
	}
	
	
	
}
