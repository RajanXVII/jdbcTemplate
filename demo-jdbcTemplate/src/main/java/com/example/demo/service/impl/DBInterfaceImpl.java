package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rajan;
import com.example.demo.service.DBInterface;

@Service
public class DBInterfaceImpl implements DBInterface {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Rajan> fetchRecord() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from rajan", (rs,rowNum)->new Rajan(
				rs.getInt("id"),rs.getString("country")));
	}

	@Override
	public List<Rajan> updateRecordById(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update rajan set country=? where id=?","Pak",id);
		return fetchRecord();
	}

	@Override
	public List<Rajan> deleteRecordById(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from rajan where id=?",id);
		return fetchRecord();
	}

	@Override
	public List<Rajan> insert(Rajan rajan) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into rajan values(?,?)",rajan.getId(),rajan.getName());
		return fetchRecord();
	}

	@Override
	public List<Rajan> updateRecord(Rajan rajan) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update rajan set id=? , country=? where id=?",rajan.getId(),rajan.getName(),rajan.getId());
		return fetchRecord();
	}

	@Override
	public Rajan fetchRecordById(int id) {
		// TODO Auto-generated method stub
		 return jdbcTemplate.queryForObject("select * from rajan where id=?", new Object[]{id},(rs,rowNum)->new Rajan(
				 rs.getInt("id"),rs.getString("country")))
				 ;
	}
	
	@Override
	public Rajan fetchRecordByIdAndName(int id, String name) {
		return jdbcTemplate.queryForObject("select * from rajan where id=? and name=?", new Object[]{id,name},(rs,rowNum)->new Rajan(
				 rs.getInt("id"),rs.getString("country")));
		
	}

}
