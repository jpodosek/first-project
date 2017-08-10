package com.example.demo.models;

public class Whisperer {
String message = null;
	
	public Whisperer(String message) {
		this.message= message;
		
	}
	
	public String makeQuiet() {
		return this.message.toLowerCase();
	}
}


