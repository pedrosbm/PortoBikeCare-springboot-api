package com.pedrosena.portobikecare.bo;

import com.pedrosena.portobikecare.dao.ClienteDao;

public class IdGen {
	public static int newId() {
		ClienteDao cDao = new ClienteDao();
		int id = cDao.selectLast();
		
		return id + 1;
	}
}
