package com.pedrosena.portobikecare.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.DateConv;

public class ClientePjVo extends ClienteVo{
	
	private String cnpj;
	private Date dataFund;
	
	/**
	 * Construtor parametrizado da classe ClientePjVo, que herda de ClienteVo.
	 * @param id - int
	 * @param nome - String
	 * @param cep - String
	 * @param email - String
	 * @param tipo - String
	 * @param cnpj - String
	 * @param dataFund - String
	 */
	public ClientePjVo(@JsonProperty("nome") String nome, @JsonProperty("cep") String cep,@JsonProperty("email")  String email, @JsonProperty("cpfcnpj") String cnpj,@JsonProperty("nasc")  String dataFund, @JsonProperty("pwd")String senha) {
		super(nome, cep, email, new SenhaVo(senha));
		this.cnpj = cnpj;
		this.dataFund = DateConv.stringToDate(dataFund);
	}
	
	public ClientePjVo(int id, String nome, String cep, String email, String cnpj, Date dataFund) {
		super(id, nome, cep, email);
		this.cnpj = cnpj;
		this.dataFund = dataFund;
	}
	
	/**
	 * Construtor vazio padrão de ClientePjVo, que herda de ClienteVo.
	 */
	public ClientePjVo() {
		
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFund() {
		return dataFund;
	}

	public void setDataFund(Date dataFund) {
		this.dataFund = dataFund;
	}
	
}
