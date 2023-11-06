package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenhaVo {
	private String senha;
	private int clienteId;
	
	public SenhaVo(@JsonProperty("senha") String senha) {
		this.senha = senha;
	}
	
	public SenhaVo() {
//		,@JsonProperty("cliente_id")  int clienteId
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
