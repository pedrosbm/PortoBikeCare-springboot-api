package com.pedrosena.portobikecare.bo;

import com.pedrosena.portobikecare.dao.BikeDao;
import com.pedrosena.portobikecare.dao.ClienteDao;

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
}
