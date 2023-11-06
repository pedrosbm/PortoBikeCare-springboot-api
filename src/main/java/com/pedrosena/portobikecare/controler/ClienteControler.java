package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ClientePfDao;
import com.pedrosena.portobikecare.dao.ClientePjDao;
import com.pedrosena.portobikecare.dao.SenhaDao;
import com.pedrosena.portobikecare.vo.ClientePfVo;
import com.pedrosena.portobikecare.vo.ClientePjVo;
import com.pedrosena.portobikecare.vo.LoginVo;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteControler {
	private ClientePfDao pfDao = new ClientePfDao();
	private ClientePjDao pjDao = new ClientePjDao();
	private SenhaDao sDao = new SenhaDao();
	
	@PostMapping(path = "/CadastroPf")
	public ResponseEntity<ClientePfVo> cadastropf(@RequestBody ClientePfVo cliente) {
		pfDao.insert(cliente);
		sDao.insert(cliente.getSenha());
		
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping(path = "/CadastroPj")
	public ResponseEntity<ClientePjVo> cadastropj(@RequestBody ClientePjVo cliente) {
		pjDao.insert(cliente);
		sDao.insert(cliente.getSenha());
		
		return ResponseEntity.ok(cliente);
	}
	
}