package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ClientePfDao;
import com.pedrosena.portobikecare.dao.ClientePjDao;
import com.pedrosena.portobikecare.vo.ClientePfVo;
import com.pedrosena.portobikecare.vo.ClientePjVo;
import com.pedrosena.portobikecare.vo.ClienteVo;
import com.pedrosena.portobikecare.vo.LoginVo;

@RestController
@RequestMapping(value = "/Login")
public class AuthControler {
	private ClientePfDao pfDao;
	private ClientePjDao pjDao;
	
	@PostMapping
	public ResponseEntity<ClienteVo> login(@PathVariable LoginVo login){
		
		ClientePfVo pf = pfDao.selectByEmail(login.getEmail());
		ClientePjVo pj = pjDao.selectByEmail(login.getEmail());
		
		if(pf.getSenha().getSenha() == login.getSenha()){
			return ResponseEntity.ok(pf);
		} else if(pj.getSenha().getSenha() == login.getSenha()){
			return ResponseEntity.ok(pj);
		} else {
			return ResponseEntity.ok(null);
		}
	}
}
