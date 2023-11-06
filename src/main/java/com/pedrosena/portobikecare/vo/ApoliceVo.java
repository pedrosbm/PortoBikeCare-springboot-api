package com.pedrosena.portobikecare.vo;

import java.sql.Date;

public class ApoliceVo {
	private int id;
	private String titular;
	private String infoBike;
	private double valorAssegurado;
	private Date dataInicio;
	private Date dataFim;
	private int cliente_id;

	public ApoliceVo(int id, String titular, String infoBike, double valorAssegurado, Date dataInicio, Date dataFim, int cliente_id) {
		this.id = id;
		this.titular = titular;
		this.infoBike = infoBike;
		this.valorAssegurado = valorAssegurado;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.cliente_id = cliente_id;
	}

	public ApoliceVo() {
		
	}

	public double getValorAssegurado() {
		return valorAssegurado;
	}

	public void setValorAssegurado(double valorAssegurado) {
		this.valorAssegurado = valorAssegurado;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getInfoBike() {
		return infoBike;
	}

	public void setInfoBike(String infoBike) {
		this.infoBike = infoBike;
	}
	
}