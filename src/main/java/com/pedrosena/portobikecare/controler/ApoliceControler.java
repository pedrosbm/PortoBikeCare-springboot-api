package com.pedrosena.portobikecare.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.ApoliceDao;
import com.pedrosena.portobikecare.vo.ApoliceVo;

@RestController
@RequestMapping(value = "/Apolice")
public class ApoliceControler {
	private ApoliceDao aDao = new ApoliceDao();
	
	@PostMapping(path = "/new")
	public ResponseEntity<String> novoApolice(@RequestBody ApoliceVo apolice){
		aDao.insert(apolice);
		
		return ResponseEntity.ok("Apolice novo");
	}
}
