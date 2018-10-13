package com.test;

public class testObject {
	
	private int id;
	private String name;
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
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
	public testObject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	

}
