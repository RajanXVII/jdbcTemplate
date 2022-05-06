package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rajan;
import com.example.demo.service.DBInterface;

@RestController
public class DemoController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DBInterface dBInterface;
	
	@GetMapping("/getAll")	
	public List<Rajan> get(){
		return dBInterface.fetchRecord();
		
	}
	
	@GetMapping("/getById")	
	public Rajan getById(@RequestParam("id") int id){
		return dBInterface.fetchRecordById(id);
		
	}
	
	@GetMapping("/getByIdAndName")	
	public Rajan getByIdAndName(@RequestParam("id") int id,@RequestParam("country") String name ){
		return dBInterface.fetchRecordByIdAndName(id,name);
		
	}
	
	
	@GetMapping("/update")	
	public List<Rajan> update(@RequestParam("id") int id){
		return dBInterface.updateRecordById(id);
		
	}
	
	@GetMapping("/delete")	
	public List<Rajan> delete(@RequestParam("id") int id){
		return dBInterface.deleteRecordById(id);
		
	}
	@PostMapping("/insert")	
	public List<Rajan> insert(@RequestBody Rajan rajan){
		return dBInterface.insert(rajan);
	}
	@PutMapping("/updateAll")
	public List<Rajan> updateAll(@RequestBody Rajan rajan){
		return dBInterface.updateRecord(rajan);
	}
	
	
	
	
}
