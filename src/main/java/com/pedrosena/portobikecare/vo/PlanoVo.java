package com.pedrosena.portobikecare.vo;

public class PlanoVo {
	private int id;
	private String nome;
	private double valor;
	private String cobertura;
	private int apoliceId;
	
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
