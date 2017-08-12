package com.example.demo.models;

public class Calculator {
	int first;
	double second;
	double add, subtract, divide, multiply, modulo, exponent;
	
	public Calculator(int first, double second) {
			
		add = first + second;
		subtract = first - second;
		multiply = first * second;
		divide = first / second;
		modulo = first % second;
		exponent = Math.pow(first, second);	
	}
	
	public double getAddResult() {
		return add;
	}
	
	public double getSubtractResult() {
		return subtract;
	}
	
	public double getMultiplyResult() {
		return multiply;
	}
	
	public double getDivideResult() {
		return divide;
	}
	
	public double getModuloResult() {
		return modulo;
	}
	public double getExponentResult() {
		return exponent;
	}	
}
