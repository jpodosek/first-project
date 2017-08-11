package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Yeller;
import com.example.demo.models.Whisperer;

@Controller
@RequestMapping({ "/", "/HelloWorld" }) // allows us to map same controller to more than one path; aka home directory
										// (/) OR /HelloWorld will both map to same controller
public class HelloWorldController {

	private String title;

	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}

	@GetMapping("")
	public String index() {
		return "helloworld/index"; // return file to render
	}

	// Yeller Model
	@GetMapping("message-path") // URL to which form submits; gets invoked when message is passed in browser
	public ModelAndView message(@RequestParam(required = false, defaultValue = "«silence»") String submittedMessage) {
		Yeller yell = new Yeller(submittedMessage);
		ModelAndView mv = new ModelAndView("helloworld/yell"); // pass in template name to view
		mv.addObject("pageTitle", title);
		// replace message below
		mv.addObject("messageDisplayText", yell.makeLoud()); // key-value pair
		return mv;
	}

	// Create a class named WHisperer that makes Strings lower case
	// Using the method below, create a method named "whisper" for a GetMapping that
	// does essentially the same thing *BUT* uses Whisperer.
	// THis means that you should map a GET to the path "whisper"
	// This means that you should have a method named "whisper" that returns a
	// ModelAndView

	@GetMapping("whisper-path") // this line here is what sets the path following main url
								// (http://localhost:8080/)
	public ModelAndView whisper(@RequestParam(required = false, defaultValue = "«silence»") String submittedMessage) {
		Whisperer whisper = new Whisperer(submittedMessage);
		// Model and View (aka HTML template) stuff combined
		ModelAndView mv = new ModelAndView("helloworld/whisper"); // ; tells Mustache to go to "helloworld/message.html"
																	// and render
		mv.addObject("pageTitle", title); // title is value of instance variable
		mv.addObject("whispermessageDisplayText", whisper.makeQuiet()); // pass message below to view template
		return mv; // returns ModelAndView object containing
	}

	@GetMapping("say-something") 
	public String makeAChoice(
			String submittedMessage, //named same as input parameters on form
			String speechChoice,
			Model theThingIPutDataIntoFoTheView
	) {
		if (speechChoice.equals("yell")) {
			//make submittedMessage loud
			Yeller yeller1 = new Yeller(submittedMessage);
			String loud = yeller1.makeLoud();
			theThingIPutDataIntoFoTheView.addAttribute("output", loud); //output will be used in mustache to show values
			} else {
			Whisperer whisper1 = new Whisperer(submittedMessage);
			String quiet = whisper1.makeQuiet();
			theThingIPutDataIntoFoTheView.addAttribute("output", quiet);
			}
			//make submittedMessage quiet
		return "helloworld/mixed-messages";
		}
	
	
}
