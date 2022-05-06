package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Rajan;

public interface DBInterface {
	List<Rajan> fetchRecord();
	Rajan fetchRecordByIdAndName(int id,String name);
	List<Rajan> updateRecordById(int id);
	List<Rajan> deleteRecordById(int id);
	List<Rajan> updateRecord(Rajan rajan);
	List<Rajan> insert(Rajan rajan);
	Rajan fetchRecordById(int id);
	
}
