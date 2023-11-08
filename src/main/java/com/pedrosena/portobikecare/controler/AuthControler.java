package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ClienteDao;
import com.pedrosena.portobikecare.dao.ClientePfDao;
import com.pedrosena.portobikecare.dao.ClientePjDao;
import com.pedrosena.portobikecare.dao.SenhaDao;
import com.pedrosena.portobikecare.vo.ClientePfVo;
import com.pedrosena.portobikecare.vo.ClientePjVo;
import com.pedrosena.portobikecare.vo.ClienteVo;
import com.pedrosena.portobikecare.vo.LoginVo;
import com.pedrosena.portobikecare.vo.SenhaVo;

@RestController
@RequestMapping(value = "/Login")
public class AuthControler {
	ClienteDao cDao = new ClienteDao();
	ClientePfDao pfDao = new ClientePfDao();
	ClientePjDao pjDao = new ClientePjDao();
	SenhaDao sDao = new SenhaDao();
	
	@PostMapping
	public ResponseEntity<ClienteVo> login(@RequestBody LoginVo login){
		
		ClienteVo c = cDao.selectByEmail(login.getEmail());
		SenhaVo s = sDao.selectById(c.getId());
		
		if(s.getSenha().equals(login.getSenha())) {

			ClientePfVo cPf = pfDao.selectById(c.getId());
			ClientePjVo cPj = pjDao.selectById(c.getId());

			if(cPf.getId() == 0){
				return ResponseEntity.ok(cPj);
			} else {
				return ResponseEntity.ok(cPf);
			}
			
		}else {
			return ResponseEntity.ok(new ClienteVo());
		}
	}
}
