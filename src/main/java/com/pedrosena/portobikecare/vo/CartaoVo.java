package com.pedrosena.portobikecare.vo;

import java.sql.Date;

public class CartaoVo {
	private long numCartao;
	private String titular;
	private Date dataVal;
	private int cvv;
	private String modalidade;
	private int pagamentoId;
	
	public CartaoVo(long numCartao, String titular, Date dataVal, int cvv, String modalidade, int pagamentoId) {
		this.numCartao = numCartao;
		this.titular = titular;
		this.dataVal = dataVal;
		this.cvv = cvv;
		this.modalidade = modalidade;
		this.pagamentoId = pagamentoId;
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
	public int getPagamentoId() {
		return pagamentoId;
	}
	public void setPagamentoId(int pagamentoId) {
		this.pagamentoId = pagamentoId;
	}
	
}
