package com.astra.anblicks.pdca.dto;

public class NamedObject<T> { 
	public final String name; 
	public final T object; 
	
	public String getName() {
		return name;
	}
	public T getObject() {
		return object;
	}
	public NamedObject(String name, T object) { 
		this.name = name; 
		this.object = object; 
		
	} 
}
