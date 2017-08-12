package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Calculator;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping({ "/", "/math" }) // this allows http://localhost:8080/math/adder to work ; without, adder only
// works at http://localhost:8080/adder
public class MathController {
	private String pageTitle;
	private Model model;

	public MathController() {
		pageTitle = "Calculator";
	}

	@GetMapping("") // default
	public String index(Model model) {
		this.model = model;
		this.model.addAttribute("pageTitle", pageTitle);
		return "math/index"; // return file to render
	}

	@GetMapping("math/calculate") // what to do if user directly goes to /math/calculate
	public String mathCalculatePath(Model model) {
		double result = 0.00;
		this.model = model;
		this.model.addAttribute("pageTitle", pageTitle);
		this.model.addAttribute("output", result); // "output" is the variable name mustache  uses	
		return "math/calculate"; // return file to render }
	}

	@PostMapping("adder")
	// @RequestParam(name="left") is the left text box on the html page - see
	// 'message-form.html'
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {

		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "math/sum-result"; // this looks up sum-result.html
	}

	@PostMapping("subtractor")
	public String subTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {

		Subtractor subber = new Subtractor(first, second);
		double result = subber.calculate();
		model.addAttribute("sub", result);
		return "math/difference-result"; // this looks up difference-result.html
	}

	@GetMapping("adder") // URL to which form submits; gets invoked when message is passed in browser
	public String showAddingForm() {
		return "math/adder-form"; // ; tells Mustache to go to "adder-form"
	}

	// Assignment
	// This logic will take form input of calculate and determine what to route
	@PostMapping("math/calculate")
	public String performCalculation(@RequestParam(name = "leftval") int left,
			@RequestParam(name = "rightval") double right, @RequestParam(name = "operation") String operation,
			Model theThingIPutDataIntoForTheView) {
		int leftVal = left;
		double rightVal = right;
		double result = 0.00;
		Calculator calc = new Calculator(leftVal, rightVal);
		// this.theThingIPutDataIntoForTheView = theThingIPutDataIntoForTheView;
		if (operation.equals("add")) {
			result = calc.getAddResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else if (operation.equals("subtract")) {
			result = calc.getSubtractResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else if (operation.equals("multiply")) {
			result = calc.getMultiplyResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else if (operation.equals("divide")) {
			result = calc.getDivideResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else if (operation.equals("modulo")) {
			result = calc.getModuloResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else if (operation.equals("exponent")) {
			result = calc.getExponentResult();
			// theThingIPutDataIntoForTheView.addAttribute("output", result);
		}

		else {
			System.out.println("No valid operation entered");
			result = 0.00;
		}

		theThingIPutDataIntoForTheView.addAttribute("output", result); // "output" is the variable name mustache  uses																// to display result"
		theThingIPutDataIntoForTheView.addAttribute("pageTitle", pageTitle);
		return "math/calculate";
	}

}
