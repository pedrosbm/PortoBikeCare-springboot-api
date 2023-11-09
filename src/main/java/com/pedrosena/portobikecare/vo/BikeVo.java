package com.pedrosena.portobikecare.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosena.portobikecare.bo.IdGen;

public class BikeVo {
	private int id;
	private String nick;
	private String tipoQuadro;
	private int quantMarcha;
	private String tipoSuspensao;
	private String tipoFreio;
	private String modalidade;
	private String marca;
	private String modelo;
	private double valor;
	private String numSerie;
	private String acessorio;
	private String tipoPneu;
	private String observacoes;
	private long nf;
	private int cliente_id;
	
	@JsonCreator
	public BikeVo(@JsonProperty("nick") String nick,@JsonProperty("tipoQuadro") String tipoQuadro,@JsonProperty("quantMarcha") int quantMarcha,@JsonProperty("tipoSuspensao") String tipoSuspensao,@JsonProperty("tipoFreio") String tipoFreio,@JsonProperty("modalidade") String modalidade,@JsonProperty("marca") String marca,@JsonProperty("modelo") String modelo,@JsonProperty("valor") double valor,@JsonProperty("numserie") String numSerie,@JsonProperty("acessorio") String acessorio,@JsonProperty("tipoPneu") String tipoPneu,@JsonProperty("observações") String observacoes,@JsonProperty("nf") long nf,@JsonProperty("nf") int cliente_id) {
		this.id = IdGen.bikeNewId();
		this.nick = nick;
		this.tipoQuadro = tipoQuadro;
		this.quantMarcha = quantMarcha;
		this.tipoSuspensao = tipoSuspensao;
		this.tipoFreio = tipoFreio;
		this.modalidade = modalidade;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.numSerie = numSerie;
		this.acessorio = acessorio;
		this.tipoPneu = tipoPneu;
		this.observacoes = observacoes;
		this.nf = nf;
		this.cliente_id = cliente_id;
	}

	public BikeVo(int id, String nick, String tipoQuadro, int quantMarcha, String tipoSuspensao, String tipoFreio, String modalidade, String marca, String modelo, double valor, String numSerie, String acessorio, String tipoPneu, String observacoes, long nf, int cliente_id) {
		this.id = id;
		this.nick = nick;
		this.tipoQuadro = tipoQuadro;
		this.quantMarcha = quantMarcha;
		this.tipoSuspensao = tipoSuspensao;
		this.tipoFreio = tipoFreio;
		this.modalidade = modalidade;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.numSerie = numSerie;
		this.acessorio = acessorio;
		this.tipoPneu = tipoPneu;
		this.observacoes = observacoes;
		this.nf = nf;
		this.cliente_id = cliente_id;
	}

	public BikeVo() {
		
	}
	
	public String getTipoQuadro() {
		return tipoQuadro;
	}

	public void setTipoQuadro(String tipoQuadro) {
		this.tipoQuadro = tipoQuadro;
	}

	public int getQuantMarcha() {
		return quantMarcha;
	}

	public void setQuantMarcha(int quantMarcha) {
		this.quantMarcha = quantMarcha;
	}

	public String getTipoSuspensao() {
		return tipoSuspensao;
	}

	public void setTipoSuspensao(String tipoSuspensao) {
		this.tipoSuspensao = tipoSuspensao;
	}

	public String getTipoFreio() {
		return tipoFreio;
	}

	public void setTipoFreio(String tipoFreio) {
		this.tipoFreio = tipoFreio;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(String acessorio) {
		this.acessorio = acessorio;
	}

	public String getTipoPneu() {
		return tipoPneu;
	}

	public void setTipoPneu(String tipoPneu) {
		this.tipoPneu = tipoPneu;
	}

	public long getNf() {
		return nf;
	}

	public void setNf(long nf) {
		this.nf = nf;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

}