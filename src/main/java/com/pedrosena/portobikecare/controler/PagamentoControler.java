package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.PagamentoDao;
import com.pedrosena.portobikecare.vo.PagamentoVo;

@RestController
@RequestMapping(value = "/Pagamento")
public class PagamentoControler {
	private PagamentoDao pdao = new PagamentoDao();
	
	@PostMapping(path = "/new")
	public ResponseEntity<PagamentoVo> novoPagamento(@RequestBody PagamentoVo pagamento){
		pdao.insert(pagamento);
		
		return ResponseEntity.ok(pagamento);
	}
	
}
