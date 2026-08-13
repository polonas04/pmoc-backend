package com.pi.unileste.pmoc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	@NotNull
	private String tipo;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "matricula_cliente")
	private Cliente cliente;
	
	public Equipamento(Integer id, String marca, String modelo, String tipo, Cliente cliente) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cliente = cliente;
	}
	
	public Equipamento() {
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setMatricula_cliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
