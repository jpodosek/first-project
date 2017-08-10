package com.example.demo.models;

public class Adder {
	
	int first;
	double second;
	//double sum;
	
	
	public Adder(int first, double second) {
		this.first = first;
		this.second = second;
		//sum = first + second;
		
	}
	
	
	public double calculate() {	
		return this.first + this.second;
		//return sum;
		} 
}



