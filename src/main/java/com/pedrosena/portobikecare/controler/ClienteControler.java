package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteControler {
	private ClientePfDao pfDao = new ClientePfDao();
	private ClientePjDao pjDao = new ClientePjDao();
	private ClienteDao cDao = new ClienteDao();
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
	
	@PutMapping(path = "/edit")
	public ResponseEntity<String> editCliente(@RequestBody ClienteVo cliente){
		cDao.update(cliente);
		
		return ResponseEntity.ok("Alterações efetuadas");
	}
	
	@GetMapping(path = "/listOne/{id}")
	public ResponseEntity<ClienteVo> listarCliente(@PathVariable int id){
		ClienteVo cliente = cDao.selectById(id);
		return ResponseEntity.ok(cliente);
	}
}