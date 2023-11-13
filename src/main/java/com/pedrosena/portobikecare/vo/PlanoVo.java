package com.pedrosena.portobikecare.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.IdGen;

public class PlanoVo {
	
	@JsonProperty("planoId")
	private int id;

	@JsonProperty("nomePlano")
	private String nome;

	@JsonProperty("valor")
	private double valor;
	
	@JsonProperty("cobertura")
	private String cobertura;

	@JsonProperty("apoliceId")
	private int apoliceId;
	
	@JsonCreator
	public PlanoVo(@JsonProperty("nomePlano") String nome,@JsonProperty("valor") double valor,@JsonProperty("cobertura") List<String> cobertura,@JsonProperty("apoliceId") int apoliceId) {
		this.id = IdGen.planoNewId();
		this.nome = nome;
		this.valor = valor;
		this.cobertura = String.join(", ", cobertura);
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
