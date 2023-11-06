package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginVo {
	private String email;
	private String senha;
	
	@JsonCreator
	public LoginVo(@JsonProperty("email")String email, @JsonProperty("senha")String senha) {
		this.email = email;
		this.senha = senha;
	}

	public LoginVo() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
