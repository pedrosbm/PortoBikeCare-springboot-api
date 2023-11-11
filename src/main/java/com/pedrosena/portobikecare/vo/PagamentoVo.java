package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.IdGen;

public class PagamentoVo {
	
	@JsonProperty("pagametoId")
	private int id;

	@JsonProperty("valor")
	private double valor;

	@JsonProperty("parcelas")
	private int parcelas;

	@JsonProperty("clienteId")
	private int clienteId;

	@JsonCreator
	public PagamentoVo(@JsonProperty("valor")double valor,@JsonProperty("parcelas") int parcelas,@JsonProperty("clienteId") int clienteId) {
		this.id = IdGen.pagamentoNewId();
		this.valor = valor;
		this.parcelas = parcelas;
		this.clienteId = clienteId;
	}
	
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
