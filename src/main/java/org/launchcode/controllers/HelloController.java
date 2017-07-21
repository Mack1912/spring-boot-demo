package org.launchcode.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloMessage;
import org.launchcode.models.Task;
import org.launchcode.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/all-tasks")
	public String getAllTasks() {
		return taskService.findAll().toString(); 
	}
	
	@GetMapping("/save-task")
	public String saveTask(@RequestParam String name, @RequestParam String desc) {
		
		Task t = new Task(name, desc, new Date(), true); // gives an error, cant convert boolean to bit
		taskService.save(t);
		
		return "Task Saved : " + t; 
	}
	
	
	
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm() {
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest request, Model model) {
		
		// get name parameter from request; will be null of no parameter passed in
		String name = request.getParameter("name");
		
		if (name == null) {
			name = "world";
		}
		
		// add a payload to model
		// here model is just a way to communicate between controller and model
		model.addAttribute("name", HelloMessage.getMessage(name));
		return "hello"; // name of the html template file without the .html extension
	}
	

	
}
