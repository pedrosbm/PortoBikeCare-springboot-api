package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.IdGen;

public class PlanoVo {
	
	@JsonProperty()
	private int id;
	private String nome;
	private double valor;
	private String cobertura;
	private int apoliceId;
	
	@JsonCreator
	public PlanoVo(@JsonProperty String nome, double valor, String cobertura, int apoliceId) {
		this.id = IdGen.planoNewId();
		this.nome = nome;
		this.valor = valor;
		this.cobertura = cobertura;
		this.apoliceId = apoliceId;
	}
	
	public PlanoVo(int id, String nome, double valor, String cobertura, int apoliceId) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.cobertura = cobertura;
		this.apoliceId = apoliceId;
	}

	public PlanoVo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	public int getApoliceId() {
		return apoliceId;
	}
	public void setApoliceId(int apoliceId) {
		this.apoliceId = apoliceId;
	}
	
}
