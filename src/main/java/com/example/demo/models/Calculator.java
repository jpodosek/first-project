package com.example.demo.models;

public class Calculator {

	public int leftVal;
	public double rightVal;
	public String operation;
	public String opDisplayText;

	public Calculator(int left, double right, String operation) {
		this.leftVal = left;
		this.rightVal = right;
		this.operation = operation;
		//this.leftVal = 0;
		//this.rightVal = 0.00;
		//this.operation = null;
		//this.opDisplayText = null;
	}

	public double Calculate() {
		
		if (operation.equals("add")) {
			this.opDisplayText = "plus";
			return leftVal + rightVal;
		}

		else if (operation.equals("subtract")) {
			this.opDisplayText = "minus";
			return leftVal - rightVal;
		}

		else if (operation.equals("multiply")) {
			this.opDisplayText = "multiplied by";
			return leftVal * rightVal;
		}

		else if (operation.equals("divide")) {
			this.opDisplayText = "divided by";
			return leftVal / rightVal;
		}

		else if (operation.equals("modulo")) {
			this.opDisplayText = "mod";
			return leftVal % rightVal;
		}

		else if (operation.equals("exponent")) {
			this.opDisplayText = "to the power of";
			return Math.pow(leftVal, rightVal);
		} else {
			this.opDisplayText = "plus";
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
		return this.opDisplayText;
	}
	

}
