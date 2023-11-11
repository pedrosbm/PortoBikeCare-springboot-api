package com.pedrosena.portobikecare.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.CartaoDao;
import com.pedrosena.portobikecare.vo.CartaoVo;

@RestController
@RequestMapping(value = "/Cartão")
public class CartaoControler {
	private CartaoDao cDao = new CartaoDao();
	
	@GetMapping(path = "/List/{id}")
	public ResponseEntity<List<CartaoVo>> listarCartoes(@PathVariable int id){
		List<CartaoVo> cartoes = cDao.selectByCliente(id);
		
		return ResponseEntity.ok(cartoes);
	}
	
	@PostMapping(path = "/new")
	public ResponseEntity<String> novoCartao(@RequestBody CartaoVo cartao){
		cDao.insert(cartao);
		
		return ResponseEntity.ok("Cartão cadastrado");
	}
}
