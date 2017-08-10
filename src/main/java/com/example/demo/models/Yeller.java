package com.example.demo.models;

public class Yeller {
	String message = "";
	
	public Yeller(String message) {
		this.message= message;
		
	}
	
	public String makeLoud() {
		return this.message.toUpperCase();
	}


}
