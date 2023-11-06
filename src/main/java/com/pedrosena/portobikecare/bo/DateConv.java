package com.pedrosena.portobikecare.bo;

import java.sql.Date;

public class DateConv {
	
	@SuppressWarnings("deprecation")
	public static Date stringToDate(String data) {
		String[] conversao = data.split("/");
		
		int dia = Integer.parseInt(conversao[0]);
		int mes = Integer.parseInt(conversao[1]);
		int ano = Integer.parseInt(conversao[2]);
		
		return new Date(ano - 1900, mes - 1, dia);
	}
}
