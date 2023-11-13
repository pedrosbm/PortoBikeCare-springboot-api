package com.pedrosena.portobikecare.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.CartaoDao;
import com.pedrosena.portobikecare.dao.PagamentoDao;
import com.pedrosena.portobikecare.vo.BikeVo;
import com.pedrosena.portobikecare.vo.CartaoVo;

@RestController
@RequestMapping(value = "/Cartão")
public class CartaoControler {
	private CartaoDao cDao = new CartaoDao();
	private PagamentoDao pDao = new PagamentoDao();
	
	@PostMapping(path = "/new/{id}")
	public ResponseEntity<CartaoVo> novoCartao(@PathVariable("id") int clienteId, @RequestBody CartaoVo cartao){
		int pagamentoId = pDao.selectLast(clienteId);
		cartao.setPagamentoId(pagamentoId);
		cDao.insert(cartao);
		
		return ResponseEntity.ok(cartao);
	}
	
	@GetMapping(path = "/list/{id}")
	public ResponseEntity<List<CartaoVo>> listarCartoes(@PathVariable int id){
		List<CartaoVo> cartoes = cDao.selectByCliente(id);
		return ResponseEntity.ok(cartoes);
	}
	
	@PutMapping(path = "/edit")
	public ResponseEntity<String> editarCartao(@RequestBody CartaoVo cartao){
		cDao.update(cartao);
		
		return ResponseEntity.ok("Cartão editado com sucesso editada com sucesso");
	}
	
	@GetMapping(path = "/listOne/{id}")
	public ResponseEntity<CartaoVo> listarPorBike(@PathVariable int id){
		CartaoVo c = cDao.selectById(id);
		
		return ResponseEntity.ok(c);
	}
}