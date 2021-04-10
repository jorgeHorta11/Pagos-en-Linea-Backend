package com.pagos.linea.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagos.linea.demo.date.PagosDateRepository;
import com.pagos.linea.demo.entitys.Pagos;

@RestController
@RequestMapping("pagos")
public class PagosRest {
	
	@Autowired
	private PagosDateRepository pagosDate;
	
	@GetMapping
	public ResponseEntity<List<Pagos>> getPagos(){
		List<Pagos> pagos = pagosDate.findAll();
	
		return ResponseEntity.ok(pagos);
	}
	
	@RequestMapping(value = "{pagosId}")
	public ResponseEntity<Pagos> getPagosById(@PathVariable("pagosId") Long pagosId){
		Optional<Pagos> optionalPagos =  pagosDate.findById(pagosId);
		
		if(optionalPagos.isPresent()) {
			return ResponseEntity.ok(optionalPagos.get());
		}else {
		return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping //Pagos (POST)
	public ResponseEntity<Pagos> createPagos(@RequestBody Pagos pagos){
		Pagos newPagos = pagosDate.save(pagos);
		return ResponseEntity.ok(newPagos);
	}
	
	@DeleteMapping(value = "{pagosId}") //Pagos (Delete)
	public ResponseEntity<Void> deletePagos(@PathVariable("pagosId") Long pagosId){
		pagosDate.deleteById(pagosId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Pagos> uodatePagosById(@RequestBody Pagos pagos){
		Optional<Pagos> optionalPagos =  pagosDate.findById(pagos.getId());	
		if(optionalPagos.isPresent()) {
			Pagos updatePagos = optionalPagos.get();
			updatePagos.setName(pagos.getName());
			updatePagos.setPrice(pagos.getPrice());
			pagosDate.save(updatePagos);
			return ResponseEntity.ok(updatePagos);
		}else {
		return ResponseEntity.notFound().build();
		}
	}
	

}
