package com.pedrosena.portobikecare.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ApoliceDao;
import com.pedrosena.portobikecare.dao.PlanoDao;
import com.pedrosena.portobikecare.vo.PlanoVo;

@RestController
@RequestMapping(value = "/Plano")
public class PlanoControler {
	private PlanoDao pDao = new PlanoDao();
	private ApoliceDao aDao = new ApoliceDao();

	@PostMapping(path = "/new/{id}")
	public ResponseEntity<PlanoVo> novoPlano(@RequestBody PlanoVo plano, @PathVariable("id") int clienteId){
		int id = aDao.selectLast(clienteId);
		plano.setApoliceId(id);
		pDao.insert(plano);
		
		return ResponseEntity.ok(plano);
	}
	
	@GetMapping(path = "/list/{id}")
	public ResponseEntity<List<PlanoVo>> listarPlanos(@PathVariable int id){
		List<PlanoVo> planos = pDao.selectByCliente(id);
		
		return ResponseEntity.ok(planos);
	}
}
