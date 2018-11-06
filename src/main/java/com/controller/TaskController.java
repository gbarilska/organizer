package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Task;
import com.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService service;
	
	@RequestMapping("/tasks")
	public Iterable<Task> getTasks() {
		return service.getAllTasks();
	}
	@RequestMapping("/tasks/{id}")
	public Optional<Task> getTask(@PathVariable Long id) {
		return service.getTaskById(id);
	}
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.POST)
	public String addTask(@PathVariable Long id,@RequestBody Task task) {
		task.setId(id);
		service.addTask(task);
		return "The task was saved";
	}
	
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
	public String updateTask(@PathVariable Long id,@RequestBody Task task) {
		task.setId(id);
		service.updateTask(task);
		return "The task was updated";
	}
	
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
	public String deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
		return "The task was deleted";
	}


}
