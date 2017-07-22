package org.launchcode.controllers;

import java.util.Date;

import org.launchcode.models.Task;
import org.launchcode.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode","MODE_HOME");
		return "index";
		
	}
	
	@RequestMapping(value = "/all-tasks")
	public String allTasks(Model model) {	
		
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode","MODE_TASKS");		
		return "index";
		
	}
	
	@RequestMapping(value = "/new-task")
	public String newTask(Model model) {	
		
//		Task task = new Task();
//		model.addAttribute(task);
		model.addAttribute("mode","MODE_NEW");		
		return "index";
		
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, Model model) {
		task.setDate_created(new Date());
		taskService.save(task);
		
		// saved record, now go back to all records page
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode","MODE_TASKS");		
		return "index";
		
	}
	
	@RequestMapping(value = "/update-task")
	public String updateTask(@RequestParam int id, Model model) {	
		model.addAttribute("tasks", taskService.findById(id));
		model.addAttribute("mode","MODE_UPDATE");		
		return "index";
		
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id,  Model model) {	
		
		taskService.delete(id);
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("mode","MODE_TASKS");		
		return "index";
		
	}
	
	
	
}
