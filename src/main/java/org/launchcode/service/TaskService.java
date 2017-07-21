package org.launchcode.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.dao.TaskRepository;
import org.launchcode.models.Task;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {
	
	private final TaskRepository taskRepository;	
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		
		for( Task t : taskRepository.findAll() ) {
			tasks.add(t);
		}
		
		return tasks;
	}
	
	public void save(Task task) {

		taskRepository.save(task);
	}
	
	public void delete(int id) {
		taskRepository.delete(id);
	}
}
