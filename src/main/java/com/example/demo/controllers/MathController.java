package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtractor;

@Controller
@RequestMapping("/math") // this allows http://localhost:8080/math/adder to work ; without, adder only
							// works at http://localhost:8080/adder
public class MathController {

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

	// Homework
	@GetMapping("adder") // URL to which form submits; gets invoked when message is passed in browser
	public String showAddingForm() {
		return "math/adder-form"; // ; tells Mustache to go to "adder-form"
	}
}
