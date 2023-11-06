package com.pedrosena.portobikecare.vo;

import java.sql.Date;

public class VistoriaVo {

	private int id;
	private Date dataVistoria;
	private String etapa;
	private int bikeid;
	
	public VistoriaVo(int id, Date dataVistoria, String etapa, int bikeid) {
		this.dataVistoria = dataVistoria;
		this.id = id;
		this.etapa = etapa;
		this.bikeid = bikeid;
	}
	
	public VistoriaVo(int id, String etapa, int bikeid) {
		java.util.Date d = new java.util.Date();
		this.dataVistoria = new Date(d.getTime());
		this.id = id;
		this.etapa = etapa;
		this.bikeid = bikeid;
	}

	public VistoriaVo() {
		java.util.Date d = new java.util.Date();
		this.dataVistoria = new Date(d.getTime());
	}
		
	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public int getBikeid() {
		return bikeid;
	}

	public void setBikeid(int bikeid) {
		this.bikeid = bikeid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

}