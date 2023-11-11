package com.pedrosena.portobikecare.bo;

import com.pedrosena.portobikecare.dao.ApoliceDao;
import com.pedrosena.portobikecare.dao.BikeDao;
import com.pedrosena.portobikecare.dao.CartaoDao;
import com.pedrosena.portobikecare.dao.ClienteDao;
import com.pedrosena.portobikecare.dao.PagamentoDao;
import com.pedrosena.portobikecare.dao.PlanoDao;

public class IdGen {
	
	public static int clienteNewId() {
		ClienteDao cDao = new ClienteDao();
		int id = cDao.selectLast();
		
		return id + 1;
	}
	
	public static int bikeNewId() {
		BikeDao bDao = new BikeDao();
		int id = bDao.selectLast();
		
		return id + 1;
	}
	
	public static int cartaoNewId() {
		CartaoDao cDao = new CartaoDao();
		int id = cDao.selectLast();
		
		return id + 1;
	}
	
	public static int apoliceNewId() {
		ApoliceDao aDao = new ApoliceDao();
		int id = aDao.selectLast();
		
		return id + 1;
	}
	
	public static int pagamentoNewId() {
		PagamentoDao pDao = new PagamentoDao();
		int id = pDao.selectLast();
		
		return id +1;
	}
	
	public static int planoNewId() {
		PlanoDao pDao = new PlanoDao();
		int id = pDao.selectLast();
		
		return id+1;
	}
}
