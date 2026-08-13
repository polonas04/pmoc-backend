package com.pi.unileste.pmoc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Servico_peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_servico_peca;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_peca")
	private Peca peca;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_servico")
	private Servico servico;
	
	@NotNull
	private Integer quantidade;

	public Servico_peca(Integer id_servico_peca, @NotNull Peca peca, @NotNull Servico servico,
			@NotNull Integer quantidade) {
		super();
		this.id_servico_peca = id_servico_peca;
		this.peca = peca;
		this.servico = servico;
		this.quantidade = quantidade;
	}

	public Integer getId_servico_peca() {
		return id_servico_peca;
	}

	public void setId_servico_peca(Integer id_servico_peca) {
		this.id_servico_peca = id_servico_peca;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
