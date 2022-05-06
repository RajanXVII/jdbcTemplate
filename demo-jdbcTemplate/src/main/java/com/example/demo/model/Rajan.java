package com.example.demo.model;

public class Rajan {
	private int id;
	private String name;
	public Rajan(){
		this.id=0;
		this.name="";
	}
	public Rajan(int id,String name){
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
