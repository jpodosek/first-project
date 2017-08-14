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
@RequestMapping({ "/", "/math"}) //  all of the URL paths that this controller will handle will start with either of these
public class MathController {
	private String pageTitle;
	
	//Constructor
	public MathController() {
		pageTitle = "Calculator";
	}

	
	@GetMapping({"", "calculate"}) // URL to which form submits; gets invoked when message is passed in browser
	public String showIndex(Model m) {
		m.addAttribute("pageTitle", this.pageTitle);
		return "math/index"; // ; reroute user to index page if they try to hit math/calculate directly
	}
	
	// Assignment
	// This logic will take form input of calculate and determine what to route
	@PostMapping("calculate")
	public String performCalculation(@RequestParam(name = "leftval") int left
									,@RequestParam(name = "rightval") double right
									, @RequestParam(name = "operation") String operation
									, Model model) 
	{
		
		Calculator calc1 = new Calculator(left, right, operation); // add parameters from form's Post attributes;
		double result = calc1.Calculate();
		model.addAttribute("pageTitle", this.pageTitle);
		model.addAttribute("leftVal", left);
		model.addAttribute("rightVal", right);
		model.addAttribute("operationText", calc1.getOp());
		model.addAttribute("output", result); // "output" is the variable name mustache uses to display result
		
		return "math/calculate";
	}
	
	
	/////Old Assignment Stuff ------------------------------------------------------------------------------------------------
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

	
	@GetMapping("adder") // URL to which form submits; gets invoked when message is passed in browser
	public String showAddingForm() {
		
		return "math/adder-form"; // ; tells Mustache to go to "adder-form"
	}
	@PostMapping("subtractor")
	public String subTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {

		Subtractor subber = new Subtractor(first, second);
		double result = subber.calculate();
		model.addAttribute("sub", result);
		return "math/difference-result"; // this looks up difference-result.html
	}
	

}
