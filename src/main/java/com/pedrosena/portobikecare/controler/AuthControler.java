package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ClienteDao;
import com.pedrosena.portobikecare.dao.ClientePfDao;
import com.pedrosena.portobikecare.dao.ClientePjDao;
import com.pedrosena.portobikecare.vo.ClientePfVo;
import com.pedrosena.portobikecare.vo.ClientePjVo;
import com.pedrosena.portobikecare.vo.ClienteVo;
import com.pedrosena.portobikecare.vo.LoginVo;

@RestController
@RequestMapping(value = "/Login")
public class AuthControler {
	ClienteDao cDao = new ClienteDao();
	
	@PostMapping
	public ResponseEntity<ClienteVo> login(@RequestBody LoginVo login){
		
		ClienteVo c = cDao.selectByEmail(login.getEmail());
		
		try {
			if(c.getSenha().getSenha() == login.getSenha()) {
				return ResponseEntity.ok(c);
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ClienteVo());	
		}
		
		return null;
	}
}