package com.example.demo.models;

public class Calculator {

	private int leftVal = 0;
	private double rightVal = 0.00;
	private String operation = null, opDisplayText = null;

	public Calculator(int left, double right, String operation) {
		this.leftVal = left;
		this.rightVal = right;
		this.operation = operation;

	}

	public double Calculate() {
		
		//perform arithmetic based on input. Also provides operation 'verb' for final result display to user
		switch(operation)
		{
			case "add":
				this.opDisplayText = "plus";
				return leftVal + rightVal;
				
			case "subtract":
				this.opDisplayText = "minus";
				return leftVal - rightVal;
				
			case "multiply":
				this.opDisplayText = "multiplied by";
				return leftVal * rightVal;
				
			case "divide":
				this.opDisplayText = "divided by";
				return leftVal / rightVal;
			
			case "modulo":
				this.opDisplayText = "mod";
				return leftVal % rightVal;
			
			case "exponent":
				this.opDisplayText = "to the power of";
				return Math.pow(leftVal, rightVal);
			
			default:
				this.opDisplayText = "plus";
				return 0.00;
		}
	}

	public String getOp() {
		return this.opDisplayText;
	}

}		


