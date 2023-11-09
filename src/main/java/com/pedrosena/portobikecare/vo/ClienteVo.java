package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedrosena.portobikecare.bo.IdGen;

public class ClienteVo {
	private int id;
	private String nome;
	private String cep;
	private String email;
	
	@JsonIgnore
	private SenhaVo senha;
	
	public ClienteVo(String nome, String cep, String email, SenhaVo senha) {
		this.id = IdGen.clienteNewId();
		this.nome = nome;
		this.cep = cep;
		this.email = email;
		this.senha = senha;
		senha.setClienteId(id);
	}
	
	public ClienteVo(int id, String nome, String cep, String email) {
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.email = email;
	}
	
	public ClienteVo(int id,String nome, String cep, String email, SenhaVo senha) {
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.email = email;
		this.senha = senha;
		senha.setClienteId(id);
	}
	
	public ClienteVo() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SenhaVo getSenha() {
		return senha;
	}

	public void setSenha(SenhaVo senha) {
		this.senha = senha;
	}

}