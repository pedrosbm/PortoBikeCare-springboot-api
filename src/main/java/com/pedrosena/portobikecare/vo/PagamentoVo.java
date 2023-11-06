package com.pedrosena.portobikecare.vo;

public class PagamentoVo {
	private int id;
	private double valor;
	private int parcelas;
	private int clienteId;

	public PagamentoVo(int id, double valor, int parcelas, int clienteId) {
		this.id = id;
		this.valor = valor;
		this.parcelas = parcelas;
		this.clienteId = clienteId;
	}

	public PagamentoVo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
}
