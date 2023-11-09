package com.pedrosena.portobikecare.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosena.portobikecare.dao.BikeDao;
import com.pedrosena.portobikecare.vo.BikeVo;

@RestController
@RequestMapping(value = "/Bike")
public class BikeControler {
	private BikeDao bikeDao = new BikeDao();
	
	@PostMapping(path = "/new")
	public ResponseEntity<String> novaBike(@RequestBody BikeVo bike){
		bikeDao.insert(bike);
		
		return ResponseEntity.ok("Bike cadastrada com sucesso");
	}
	
	@GetMapping(path = "list/{id}")
	public ResponseEntity<List<BikeVo>> listarBikes(@PathVariable int id){
		List<BikeVo> list = bikeDao.selectByUser(id);
		
		return ResponseEntity.ok(list);
	}
}