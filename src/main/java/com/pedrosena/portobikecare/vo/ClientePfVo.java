package com.pedrosena.portobikecare.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.DateConv;

public class ClientePfVo extends ClienteVo{

	private String cpf;
	private Date dataNasc;

	/**
	 * Construtor parametrizado da classe ClientePfVo, que herda de ClienteVo.
	 * @param id - int
	 * @param nome - String
	 * @param cep - String
	 * @param email - String
	 * @param cpf - String
	 * @param dataNasc - Date java.util
	 */
	
	@JsonCreator
	public ClientePfVo(@JsonProperty("nome") String nome, @JsonProperty("cep")  String cep, @JsonProperty("email") String email, @JsonProperty("cpfcnpj") String cpf, @JsonProperty("nasc") String dataNasc, @JsonProperty("pwd")String senha ) {
		super(nome, cep, email, new SenhaVo(senha));
		this.cpf = cpf;
		this.dataNasc = DateConv.stringToDate(dataNasc);
	}
	
	public ClientePfVo(int id, String nome,  String cep, String email, String cpf, Date dataNasc) {
		super(id, nome, cep, email);
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	/**
	 * Construtor vazio padrão de ClientePfVo, que herda de ClienteVo.
	 */
	public ClientePfVo() {
		
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
}
