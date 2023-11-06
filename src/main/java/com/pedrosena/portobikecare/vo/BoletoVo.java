package com.pedrosena.portobikecare.vo;

import java.sql.Date;

public class BoletoVo {
	private int boleto_id;
	private String titular;
	private String remetente;
	private Date vencBoleto;
	private String numCod;
	private String agencia;
	private int pagamento_id;

	
	
	public BoletoVo(int boleto_id, String titular, String remetente, Date vencBoleto, String numCod, String agencia, int pagamento_id) {
		this.boleto_id = boleto_id;
		this.titular = titular;
		this.remetente = remetente;
		this.vencBoleto = vencBoleto;
		this.numCod = numCod;
		this.agencia = agencia;
		this.pagamento_id = pagamento_id;
	}

	public BoletoVo() {
		
	}
	
	public int getBoleto_id() {
		return boleto_id;
	}
	
	public void setBoleto_id(int boleto_id) {
		this.boleto_id = boleto_id;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getRemetente() {
		return remetente;
	}
	
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	public Date getVencBoleto() {
		return vencBoleto;
	}
	
	public void setVencBoleto(Date vencBoleto) {
		this.vencBoleto = vencBoleto;
	}
	
	public String getNumCod() {
		return numCod;
	}
	
	public void setNumCod(String numCod) {
		this.numCod = numCod;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public int getPagamento_id() {
		return pagamento_id;
	}
	
	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
}
