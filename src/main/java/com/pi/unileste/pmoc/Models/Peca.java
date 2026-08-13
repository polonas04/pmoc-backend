package com.pi.unileste.pmoc.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private Double preco;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	@NotNull
	private Integer estoque;
	
	public Peca(@NotNull String nome, @NotNull Double preco, @NotNull String marca, @NotNull String modelo,
			@NotNull Integer estoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.modelo = modelo;
		this.estoque = estoque;
	}
	
	public Peca() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
}
