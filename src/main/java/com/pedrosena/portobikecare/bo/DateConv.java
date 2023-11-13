package com.pedrosena.portobikecare.bo;

import java.sql.Date;

@SuppressWarnings("deprecation")
public class DateConv {
	
	public static Date stringToDate(String data) {
		String[] conversao = data.split("/");
		
		int dia = Integer.parseInt(conversao[0]);
		int mes = Integer.parseInt(conversao[1]);
		int ano = Integer.parseInt(conversao[2]);

		return new Date(ano - 1900, mes - 1, dia);
	}

	public static Date minStringToDate(String dataMenor) {
		String[] conversao = dataMenor.split("/");

		int dia = 1;
		int mes = Integer.parseInt(conversao[0]);
		int ano = Integer.parseInt("20".concat(conversao[1]));		
		
		return new Date(ano - 1900, mes - 1, dia);
	}
}
