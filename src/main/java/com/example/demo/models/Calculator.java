package com.example.demo.models;

public class Calculator {
	public int leftVal;
	public double rightVal;
	//double add, subtract, divide, multiply, modulo, exponent;
	public String operation;
	
	//add = first + second;
	//subtract = first - second;
	//multiply = first * second;
	//divide = first / second;
	//modulo = first % second;
	//exponent = Math.pow(first, second);	
	
	public Calculator(int first, double second, String operation) {
			this.leftVal = first;
			this.rightVal = second;
			this.operation = operation;
				
	}
	
	public double Calculate() {
		if (operation.equals("add")) {
			return leftVal + rightVal;
		}
		
		else if (operation.equals("subtract")) {
			return leftVal - rightVal;
		}
		
		else if (operation.equals("multiply")) {
			return leftVal * rightVal;
		}
		
		else if (operation.equals("divide")) {
			return leftVal / rightVal;
		}
		
		else if (operation.equals("modulo")) {
			return leftVal % rightVal;
		}
		
		else if (operation.equals("exponent")) {
			return Math.pow(leftVal, rightVal);
		}
		else {
			return 0.00;
		}
	}
	
	public int getLeftVal() {
		return this.leftVal;
	}
	
	public double getRightVal() {
		return this.rightVal;
	}
	
	public String getOp() {
		return this.operation;
	}
	
	/*
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
	
	*/
	
	
}
