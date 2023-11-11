package com.pedrosena.portobikecare.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.DateConv;
import com.pedrosena.portobikecare.bo.IdGen;

public class CartaoVo {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("pagamentoId")
	private long pagamentoId;
	
	@JsonProperty("numCartao")
	private long numCartao;
	
	@JsonProperty("titular")
	private String titular;
	
	@JsonProperty("dataVal")
	private Date dataVal;
	
	@JsonProperty("cvv")
	private int cvv;

	@JsonProperty("modalidade")
	private String modalidade;

	@JsonProperty("clienteId")
	private int clienteId;
	
	@JsonCreator
	public CartaoVo(@JsonProperty("pagamentoId")long pagamentoId,@JsonProperty("numCartao") long numCartao,@JsonProperty("titular") String titular,@JsonProperty("dataVal") String dataVal,@JsonProperty("cvv") int cvv,@JsonProperty("modalidade") String modalidade, int clienteId) {
		this.id = IdGen.cartaoNewId();
		this.pagamentoId = pagamentoId;
		this.numCartao = numCartao;
		this.titular = titular;
		this.dataVal = DateConv.stringToDate(dataVal);
		this.cvv = cvv;
		this.modalidade = modalidade;
		this.clienteId = clienteId;
	}	

	public CartaoVo(int id, long pagamentoId, long numCartao, String titular, Date dataVal, int cvv, String modalidade, int clienteId) {
		this.id = id;
		this.pagamentoId = pagamentoId;
		this.numCartao = numCartao;
		this.titular = titular;
		this.dataVal = dataVal;
		this.cvv = cvv;
		this.modalidade = modalidade;
		this.clienteId = clienteId;
	}

	public CartaoVo() {
		
	}
	
	public long getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(long numCartao) {
		this.numCartao = numCartao;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Date getDataVal() {
		return dataVal;
	}
	public void setDataVal(Date dataVal) {
		this.dataVal = dataVal;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public long getPagamentoId() {
		return pagamentoId;
	}

	public void setPagamentoId(long pagamentoId) {
		this.pagamentoId = pagamentoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}