package com.pedrosena.portobikecare.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.IdGen;

public class ApoliceVo {
	
	@JsonProperty("apoliceId")
	private int id;
	
	@JsonProperty("titular")
	private String titular;

	@JsonProperty("infoBike")
	private String infoBike;

	@JsonProperty("valorAssegurado")
	private double valorAssegurado;

	@JsonProperty("dataInicio")
	private Date dataInicio;

	@JsonProperty("dataFim")
	private Date dataFim;

	@JsonProperty("clienteId")
	private int cliente_id;

	@JsonCreator
	@SuppressWarnings("deprecation")
	public ApoliceVo(@JsonProperty("titular") String titular, @JsonProperty("infoBike") String infoBike, @JsonProperty("valorAssegurado") double valorAssegurado,@JsonProperty("dataInicio") Date dataInicio,@JsonProperty("clienteId") int cliente_id) {
		this.id = IdGen.apoliceNewId();
		this.titular = titular;
		this.infoBike = infoBike;
		this.valorAssegurado = valorAssegurado;
		this.dataInicio = dataInicio;
		this.dataFim = new Date((int) (getDataInicio().getYear() - 1.899), getDataInicio().getMonth() -1, getDataInicio().getDate());
		this.cliente_id = cliente_id;
	}
	
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