package org.launchcode.dao;

import org.launchcode.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	
}
